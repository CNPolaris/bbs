package com.polaris.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.bbs.common.enums.StatusEnum;
import com.polaris.bbs.common.utils.StringUtils;
import com.polaris.bbs.dto.editor.topic.TopicEdit;
import com.polaris.bbs.dto.editor.topic.TopicRequestPage;
import com.polaris.bbs.pojo.BbsTopic;
import com.polaris.bbs.mapper.BbsTopicMapper;
import com.polaris.bbs.service.IBbsContentService;
import com.polaris.bbs.service.IBbsTopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author polaris
 * @since 2022-05-30
 */
@Service
public class BbsTopicServiceImpl extends ServiceImpl<BbsTopicMapper, BbsTopic> implements IBbsTopicService {

    private final BbsTopicMapper topicMapper;
    private final IBbsContentService contentService;

    public BbsTopicServiceImpl(BbsTopicMapper topicMapper, IBbsContentService contentService) {
        this.topicMapper = topicMapper;
        this.contentService = contentService;
    }


    @Override
    public Page<BbsTopic> getTopicPage(TopicRequestPage model) {
        Page<BbsTopic> page = new Page<>(model.getPage(), model.getLimit());
        QueryWrapper<BbsTopic> queryWrapper = new QueryWrapper<>();
        if(model.getSectionId()!=null){
            queryWrapper.eq("section_id", model.getSectionId());
        }
        return topicMapper.selectPage(page, queryWrapper.orderByDesc("create_time"));
    }

    @Override
    public BbsTopic editTopic(Long userId, TopicEdit model, HttpServletRequest request) {
        Date date = new Date();
        // id为空，则新建
        if(model.getId()==null){
            BbsTopic bbsTopic = new BbsTopic();
            // 基本信息
            bbsTopic.setSectionId(model.getSectionId());
            bbsTopic.setCreateUser(userId);
            bbsTopic.setStatus(StatusEnum.OK.getCode());
            bbsTopic.setReadCount(0);
            bbsTopic.setReplyCount(0);
            bbsTopic.setTitle(model.getTitle());
            bbsTopic.setCreateTime(date);
            bbsTopic.setContent(model.getContent());
            // ip信息
            String ip = StringUtils.getIp(request);
            String cityInfo = StringUtils.getCityInfo(ip);
            bbsTopic.setIp(ip);
            bbsTopic.setAddress(cityInfo);

            save(bbsTopic);
            return bbsTopic;
        }
        // id存在，则修改
        else {
            BbsTopic bbsTopic = topicMapper.updateTopic(model);
//            BbsContent bbsContent = contentService.getById(bbsTopic.getContentId());
//            if(model.getContent()!=null){
//                bbsContent.setContent(model.getContent());
//            }
            updateById(bbsTopic);
//            contentService.updateById(bbsContent);
            return bbsTopic;
        }
    }
}
