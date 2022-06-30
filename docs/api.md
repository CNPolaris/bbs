---
title: bbs v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.11"

---

# bbs

> v1.0.0

# 通用模块

<a id="opIdloginUsingPOST"></a>

## POST 登录

POST /api/bbs/login

> Body 请求参数

```json
{
  "password": "string",
  "username": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|[LoginParam](#schemaloginparam)| 否 | LoginParam|none|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[RespBean](#schemarespbean)|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

<a id="opIduploadImageUsingPOST"></a>

## POST 上传图片

POST /api/bbs/image/upload

> Body 请求参数

```yaml
file: string

```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» file|body|string(binary)| 是 ||file|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[RespBean](#schemarespbean)|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

<a id="opIdgetUserInfoUsingGET"></a>

## GET 获取用户信息

GET /api/bbs/info

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|name|query|string| 否 ||none|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[RespBean](#schemarespbean)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

<a id="opIdregisterUsingPOST"></a>

## POST 普通用户注册

POST /api/bbs/register

> Body 请求参数

```json
{
  "passwordOne": "string",
  "passwordTwo": "string",
  "userName": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|[UserRegisterParam](#schemauserregisterparam)| 否 | UserRegisterParam|none|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[RespBean](#schemarespbean)|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

<a id="opIdlogoutUsingPOST"></a>

## POST 登出

POST /api/bbs/logout

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|name|query|string| 否 ||none|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[RespBean](#schemarespbean)|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

# 帖子管理模块

<a id="opIdgetTopicPageUsingPOST"></a>

## POST 分页获取帖子

POST /api/bbs/topic/page

> Body 请求参数

```json
{
  "limit": 0,
  "page": 0,
  "sectionId": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|[TopicRequestPage](#schematopicrequestpage)| 否 | TopicRequestPage|none|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[RespBean](#schemarespbean)|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

<a id="opIdcreateTopicUsingPOST"></a>

## POST 编辑帖子

POST /api/bbs/topic/edit

> Body 请求参数

```json
{
  "content": "string",
  "createTime": "2019-08-24T14:15:22Z",
  "createUser": 0,
  "id": 0,
  "readCount": 0,
  "replyCount": 0,
  "sectionId": 0,
  "status": 0,
  "title": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|name|query|string| 否 ||none|
|body|body|[TopicEdit](#schematopicedit)| 否 | TopicEdit|none|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[RespBean](#schemarespbean)|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

# 用户端

<a id="opIdgetMoreCommentListUsingPOST"></a>

## POST 展开获取更多评论

POST /api/bbs/reply/comment/more

> Body 请求参数

```json
{
  "commentLevel": 0,
  "limit": 0,
  "page": 0,
  "parentCommentId": 0,
  "topicId": 0,
  "twoLimit": 0,
  "twoPage": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|[ReplySearchParam](#schemareplysearchparam)| 否 | ReplySearchParam|none|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[RespBean](#schemarespbean)|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

<a id="opIdgetCommentListUsingPOST"></a>

## POST 获取评论

POST /api/bbs/reply/comment/list

> Body 请求参数

```json
{
  "commentLevel": 0,
  "limit": 0,
  "page": 0,
  "parentCommentId": 0,
  "topicId": 0,
  "twoLimit": 0,
  "twoPage": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|[ReplySearchParam](#schemareplysearchparam)| 否 | ReplySearchParam|none|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[RespBean](#schemarespbean)|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

<a id="opIdaddCommentUsingPOST"></a>

## POST 发表评论

POST /api/bbs/reply/comment

> Body 请求参数

```json
{
  "address": "string",
  "commentLevel": 0,
  "content": "string",
  "createTime": "2019-08-24T14:15:22Z",
  "createUser": 0,
  "id": 0,
  "ip": "string",
  "parentCommentId": 0,
  "title": "string",
  "topicId": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|name|query|string| 否 ||none|
|body|body|[BbsReply对象](#schemabbsreply%e5%af%b9%e8%b1%a1)| 否 | BbsReply对象|none|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[RespBean](#schemarespbean)|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created|Inline|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

# 文章模块

<a id="opIdselectTopicUsingGET"></a>

## GET 查看详情

GET /api/bbs/topic/select/{id}

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|path|integer| 是 ||id|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[RespBean](#schemarespbean)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Unauthorized|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Forbidden|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

### 返回数据结构

# 数据模型

<h2 id="tocS_Resource">Resource</h2>

<a id="schemaresource"></a>
<a id="schema_Resource"></a>
<a id="tocSresource"></a>
<a id="tocsresource"></a>

```json
{
  "description": "string",
  "file": {
    "absolute": true,
    "absoluteFile": {
      "absolute": true,
      "absoluteFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "absolutePath": "string",
      "canonicalFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "canonicalPath": "string",
      "directory": true,
      "executable": true,
      "file": true,
      "freeSpace": 0,
      "hidden": true,
      "lastModified": 0,
      "name": "string",
      "parent": "string",
      "parentFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "path": "string",
      "readable": true,
      "totalSpace": 0,
      "usableSpace": 0,
      "writable": true
    },
    "absolutePath": "string",
    "canonicalFile": {
      "absolute": true,
      "absoluteFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "absolutePath": "string",
      "canonicalFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "canonicalPath": "string",
      "directory": true,
      "executable": true,
      "file": true,
      "freeSpace": 0,
      "hidden": true,
      "lastModified": 0,
      "name": "string",
      "parent": "string",
      "parentFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "path": "string",
      "readable": true,
      "totalSpace": 0,
      "usableSpace": 0,
      "writable": true
    },
    "canonicalPath": "string",
    "directory": true,
    "executable": true,
    "file": true,
    "freeSpace": 0,
    "hidden": true,
    "lastModified": 0,
    "name": "string",
    "parent": "string",
    "parentFile": {
      "absolute": true,
      "absoluteFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "absolutePath": "string",
      "canonicalFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "canonicalPath": "string",
      "directory": true,
      "executable": true,
      "file": true,
      "freeSpace": 0,
      "hidden": true,
      "lastModified": 0,
      "name": "string",
      "parent": "string",
      "parentFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "path": "string",
      "readable": true,
      "totalSpace": 0,
      "usableSpace": 0,
      "writable": true
    },
    "path": "string",
    "readable": true,
    "totalSpace": 0,
    "usableSpace": 0,
    "writable": true
  },
  "filename": "string",
  "inputStream": {},
  "open": true,
  "readable": true,
  "uri": {
    "absolute": true,
    "authority": "string",
    "fragment": "string",
    "host": "string",
    "opaque": true,
    "path": "string",
    "port": 0,
    "query": "string",
    "rawAuthority": "string",
    "rawFragment": "string",
    "rawPath": "string",
    "rawQuery": "string",
    "rawSchemeSpecificPart": "string",
    "rawUserInfo": "string",
    "scheme": "string",
    "schemeSpecificPart": "string",
    "userInfo": "string"
  },
  "url": {
    "authority": "string",
    "content": {},
    "defaultPort": 0,
    "deserializedFields": {},
    "file": "string",
    "host": "string",
    "path": "string",
    "port": 0,
    "protocol": "string",
    "query": "string",
    "ref": "string",
    "serializedHashCode": 0,
    "userInfo": "string"
  }
}

```

Resource

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|description|string|false|none||none|
|file|[File](#schemafile)|false|none||none|
|filename|string|false|none||none|
|inputStream|[InputStream](#schemainputstream)|false|none||none|
|open|boolean|false|none||none|
|readable|boolean|false|none||none|
|uri|[URI](#schemauri)|false|none||none|
|url|[URL](#schemaurl)|false|none||none|

<h2 id="tocS_URI">URI</h2>

<a id="schemauri"></a>
<a id="schema_URI"></a>
<a id="tocSuri"></a>
<a id="tocsuri"></a>

```json
{
  "absolute": true,
  "authority": "string",
  "fragment": "string",
  "host": "string",
  "opaque": true,
  "path": "string",
  "port": 0,
  "query": "string",
  "rawAuthority": "string",
  "rawFragment": "string",
  "rawPath": "string",
  "rawQuery": "string",
  "rawSchemeSpecificPart": "string",
  "rawUserInfo": "string",
  "scheme": "string",
  "schemeSpecificPart": "string",
  "userInfo": "string"
}

```

URI

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|absolute|boolean|false|none||none|
|authority|string|false|none||none|
|fragment|string|false|none||none|
|host|string|false|none||none|
|opaque|boolean|false|none||none|
|path|string|false|none||none|
|port|integer(int32)|false|none||none|
|query|string|false|none||none|
|rawAuthority|string|false|none||none|
|rawFragment|string|false|none||none|
|rawPath|string|false|none||none|
|rawQuery|string|false|none||none|
|rawSchemeSpecificPart|string|false|none||none|
|rawUserInfo|string|false|none||none|
|scheme|string|false|none||none|
|schemeSpecificPart|string|false|none||none|
|userInfo|string|false|none||none|

<h2 id="tocS_UserRegisterParam">UserRegisterParam</h2>

<a id="schemauserregisterparam"></a>
<a id="schema_UserRegisterParam"></a>
<a id="tocSuserregisterparam"></a>
<a id="tocsuserregisterparam"></a>

```json
{
  "passwordOne": "string",
  "passwordTwo": "string",
  "userName": "string"
}

```

UserRegisterParam

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|passwordOne|string|false|none||none|
|passwordTwo|string|false|none||none|
|userName|string|false|none||none|

<h2 id="tocS_URL">URL</h2>

<a id="schemaurl"></a>
<a id="schema_URL"></a>
<a id="tocSurl"></a>
<a id="tocsurl"></a>

```json
{
  "authority": "string",
  "content": {},
  "defaultPort": 0,
  "deserializedFields": {},
  "file": "string",
  "host": "string",
  "path": "string",
  "port": 0,
  "protocol": "string",
  "query": "string",
  "ref": "string",
  "serializedHashCode": 0,
  "userInfo": "string"
}

```

URL

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|authority|string|false|none||none|
|content|object|false|none||none|
|defaultPort|integer(int32)|false|none||none|
|deserializedFields|[URLStreamHandler](#schemaurlstreamhandler)|false|none||none|
|file|string|false|none||none|
|host|string|false|none||none|
|path|string|false|none||none|
|port|integer(int32)|false|none||none|
|protocol|string|false|none||none|
|query|string|false|none||none|
|ref|string|false|none||none|
|serializedHashCode|integer(int32)|false|none||none|
|userInfo|string|false|none||none|

<h2 id="tocS_LoginParam">LoginParam</h2>

<a id="schemaloginparam"></a>
<a id="schema_LoginParam"></a>
<a id="tocSloginparam"></a>
<a id="tocsloginparam"></a>

```json
{
  "password": "string",
  "username": "string"
}

```

LoginParam

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|password|string|true|none||密码|
|username|string|true|none||用户名|

<h2 id="tocS_File">File</h2>

<a id="schemafile"></a>
<a id="schema_File"></a>
<a id="tocSfile"></a>
<a id="tocsfile"></a>

```json
{
  "absolute": true,
  "absoluteFile": {
    "absolute": true,
    "absoluteFile": {
      "absolute": true,
      "absoluteFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "absolutePath": "string",
      "canonicalFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "canonicalPath": "string",
      "directory": true,
      "executable": true,
      "file": true,
      "freeSpace": 0,
      "hidden": true,
      "lastModified": 0,
      "name": "string",
      "parent": "string",
      "parentFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "path": "string",
      "readable": true,
      "totalSpace": 0,
      "usableSpace": 0,
      "writable": true
    },
    "absolutePath": "string",
    "canonicalFile": {
      "absolute": true,
      "absoluteFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "absolutePath": "string",
      "canonicalFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "canonicalPath": "string",
      "directory": true,
      "executable": true,
      "file": true,
      "freeSpace": 0,
      "hidden": true,
      "lastModified": 0,
      "name": "string",
      "parent": "string",
      "parentFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "path": "string",
      "readable": true,
      "totalSpace": 0,
      "usableSpace": 0,
      "writable": true
    },
    "canonicalPath": "string",
    "directory": true,
    "executable": true,
    "file": true,
    "freeSpace": 0,
    "hidden": true,
    "lastModified": 0,
    "name": "string",
    "parent": "string",
    "parentFile": {
      "absolute": true,
      "absoluteFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "absolutePath": "string",
      "canonicalFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "canonicalPath": "string",
      "directory": true,
      "executable": true,
      "file": true,
      "freeSpace": 0,
      "hidden": true,
      "lastModified": 0,
      "name": "string",
      "parent": "string",
      "parentFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "path": "string",
      "readable": true,
      "totalSpace": 0,
      "usableSpace": 0,
      "writable": true
    },
    "path": "string",
    "readable": true,
    "totalSpace": 0,
    "usableSpace": 0,
    "writable": true
  },
  "absolutePath": "string",
  "canonicalFile": {
    "absolute": true,
    "absoluteFile": {
      "absolute": true,
      "absoluteFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "absolutePath": "string",
      "canonicalFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "canonicalPath": "string",
      "directory": true,
      "executable": true,
      "file": true,
      "freeSpace": 0,
      "hidden": true,
      "lastModified": 0,
      "name": "string",
      "parent": "string",
      "parentFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "path": "string",
      "readable": true,
      "totalSpace": 0,
      "usableSpace": 0,
      "writable": true
    },
    "absolutePath": "string",
    "canonicalFile": {
      "absolute": true,
      "absoluteFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "absolutePath": "string",
      "canonicalFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "canonicalPath": "string",
      "directory": true,
      "executable": true,
      "file": true,
      "freeSpace": 0,
      "hidden": true,
      "lastModified": 0,
      "name": "string",
      "parent": "string",
      "parentFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "path": "string",
      "readable": true,
      "totalSpace": 0,
      "usableSpace": 0,
      "writable": true
    },
    "canonicalPath": "string",
    "directory": true,
    "executable": true,
    "file": true,
    "freeSpace": 0,
    "hidden": true,
    "lastModified": 0,
    "name": "string",
    "parent": "string",
    "parentFile": {
      "absolute": true,
      "absoluteFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "absolutePath": "string",
      "canonicalFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "canonicalPath": "string",
      "directory": true,
      "executable": true,
      "file": true,
      "freeSpace": 0,
      "hidden": true,
      "lastModified": 0,
      "name": "string",
      "parent": "string",
      "parentFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "path": "string",
      "readable": true,
      "totalSpace": 0,
      "usableSpace": 0,
      "writable": true
    },
    "path": "string",
    "readable": true,
    "totalSpace": 0,
    "usableSpace": 0,
    "writable": true
  },
  "canonicalPath": "string",
  "directory": true,
  "executable": true,
  "file": true,
  "freeSpace": 0,
  "hidden": true,
  "lastModified": 0,
  "name": "string",
  "parent": "string",
  "parentFile": {
    "absolute": true,
    "absoluteFile": {
      "absolute": true,
      "absoluteFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "absolutePath": "string",
      "canonicalFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "canonicalPath": "string",
      "directory": true,
      "executable": true,
      "file": true,
      "freeSpace": 0,
      "hidden": true,
      "lastModified": 0,
      "name": "string",
      "parent": "string",
      "parentFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "path": "string",
      "readable": true,
      "totalSpace": 0,
      "usableSpace": 0,
      "writable": true
    },
    "absolutePath": "string",
    "canonicalFile": {
      "absolute": true,
      "absoluteFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "absolutePath": "string",
      "canonicalFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "canonicalPath": "string",
      "directory": true,
      "executable": true,
      "file": true,
      "freeSpace": 0,
      "hidden": true,
      "lastModified": 0,
      "name": "string",
      "parent": "string",
      "parentFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "path": "string",
      "readable": true,
      "totalSpace": 0,
      "usableSpace": 0,
      "writable": true
    },
    "canonicalPath": "string",
    "directory": true,
    "executable": true,
    "file": true,
    "freeSpace": 0,
    "hidden": true,
    "lastModified": 0,
    "name": "string",
    "parent": "string",
    "parentFile": {
      "absolute": true,
      "absoluteFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "absolutePath": "string",
      "canonicalFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "canonicalPath": "string",
      "directory": true,
      "executable": true,
      "file": true,
      "freeSpace": 0,
      "hidden": true,
      "lastModified": 0,
      "name": "string",
      "parent": "string",
      "parentFile": {
        "absolute": true,
        "absoluteFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "absolutePath": "string",
        "canonicalFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "canonicalPath": "string",
        "directory": true,
        "executable": true,
        "file": true,
        "freeSpace": 0,
        "hidden": true,
        "lastModified": 0,
        "name": "string",
        "parent": "string",
        "parentFile": {
          "absolute": null,
          "absoluteFile": null,
          "absolutePath": null,
          "canonicalFile": null,
          "canonicalPath": null,
          "directory": null,
          "executable": null,
          "file": null,
          "freeSpace": null,
          "hidden": null,
          "lastModified": null,
          "name": null,
          "parent": null,
          "parentFile": null,
          "path": null,
          "readable": null,
          "totalSpace": null,
          "usableSpace": null,
          "writable": null
        },
        "path": "string",
        "readable": true,
        "totalSpace": 0,
        "usableSpace": 0,
        "writable": true
      },
      "path": "string",
      "readable": true,
      "totalSpace": 0,
      "usableSpace": 0,
      "writable": true
    },
    "path": "string",
    "readable": true,
    "totalSpace": 0,
    "usableSpace": 0,
    "writable": true
  },
  "path": "string",
  "readable": true,
  "totalSpace": 0,
  "usableSpace": 0,
  "writable": true
}

```

File

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|absolute|boolean|false|none||none|
|absoluteFile|[File](#schemafile)|false|none||none|
|absolutePath|string|false|none||none|
|canonicalFile|[File](#schemafile)|false|none||none|
|canonicalPath|string|false|none||none|
|directory|boolean|false|none||none|
|executable|boolean|false|none||none|
|file|boolean|false|none||none|
|freeSpace|integer(int64)|false|none||none|
|hidden|boolean|false|none||none|
|lastModified|integer(int64)|false|none||none|
|name|string|false|none||none|
|parent|string|false|none||none|
|parentFile|[File](#schemafile)|false|none||none|
|path|string|false|none||none|
|readable|boolean|false|none||none|
|totalSpace|integer(int64)|false|none||none|
|usableSpace|integer(int64)|false|none||none|
|writable|boolean|false|none||none|

<h2 id="tocS_BbsReply对象">BbsReply对象</h2>

<a id="schemabbsreply对象"></a>
<a id="schema_BbsReply对象"></a>
<a id="tocSbbsreply对象"></a>
<a id="tocsbbsreply对象"></a>

```json
{
  "address": "string",
  "commentLevel": 0,
  "content": "string",
  "createTime": "2019-08-24T14:15:22Z",
  "createUser": 0,
  "id": 0,
  "ip": "string",
  "parentCommentId": 0,
  "title": "string",
  "topicId": 0
}

```

BbsReply对象

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|address|string|false|none||地址|
|commentLevel|integer(int32)|false|none||评论级别|
|content|string|false|none||评论内容|
|createTime|string(date-time)|false|none||评论时间|
|createUser|integer(int64)|false|none||评论人ID|
|id|integer(int64)|false|none||评论ID|
|ip|string|false|none||ip|
|parentCommentId|integer(int64)|false|none||父级评论ID|
|title|string|false|none||文章标题|
|topicId|integer(int64)|false|none||评论的文章ID|

<h2 id="tocS_TopicRequestPage">TopicRequestPage</h2>

<a id="schematopicrequestpage"></a>
<a id="schema_TopicRequestPage"></a>
<a id="tocStopicrequestpage"></a>
<a id="tocstopicrequestpage"></a>

```json
{
  "limit": 0,
  "page": 0,
  "sectionId": 0
}

```

TopicRequestPage

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|limit|integer(int32)|false|none||none|
|page|integer(int32)|false|none||none|
|sectionId|integer(int32)|false|none||none|

<h2 id="tocS_TopicEdit">TopicEdit</h2>

<a id="schematopicedit"></a>
<a id="schema_TopicEdit"></a>
<a id="tocStopicedit"></a>
<a id="tocstopicedit"></a>

```json
{
  "content": "string",
  "createTime": "2019-08-24T14:15:22Z",
  "createUser": 0,
  "id": 0,
  "readCount": 0,
  "replyCount": 0,
  "sectionId": 0,
  "status": 0,
  "title": "string"
}

```

TopicEdit

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|content|string|false|none||none|
|createTime|string(date-time)|false|none||none|
|createUser|integer(int64)|false|none||none|
|id|integer(int64)|false|none||none|
|readCount|integer(int32)|false|none||none|
|replyCount|integer(int32)|false|none||none|
|sectionId|integer(int64)|false|none||none|
|status|integer(int32)|false|none||none|
|title|string|false|none||none|

<h2 id="tocS_URLStreamHandler">URLStreamHandler</h2>

<a id="schemaurlstreamhandler"></a>
<a id="schema_URLStreamHandler"></a>
<a id="tocSurlstreamhandler"></a>
<a id="tocsurlstreamhandler"></a>

```json
{}

```

URLStreamHandler

### 属性

*None*

<h2 id="tocS_RespBean">RespBean</h2>

<a id="schemarespbean"></a>
<a id="schema_RespBean"></a>
<a id="tocSrespbean"></a>
<a id="tocsrespbean"></a>

```json
{
  "code": 0,
  "data": {},
  "message": "string"
}

```

RespBean

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer(int64)|false|none||none|
|data|object|false|none||none|
|message|string|false|none||none|

<h2 id="tocS_InputStream">InputStream</h2>

<a id="schemainputstream"></a>
<a id="schema_InputStream"></a>
<a id="tocSinputstream"></a>
<a id="tocsinputstream"></a>

```json
{}

```

InputStream

### 属性

*None*

<h2 id="tocS_ReplySearchParam">ReplySearchParam</h2>

<a id="schemareplysearchparam"></a>
<a id="schema_ReplySearchParam"></a>
<a id="tocSreplysearchparam"></a>
<a id="tocsreplysearchparam"></a>

```json
{
  "commentLevel": 0,
  "limit": 0,
  "page": 0,
  "parentCommentId": 0,
  "topicId": 0,
  "twoLimit": 0,
  "twoPage": 0
}

```

ReplySearchParam

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|commentLevel|integer(int32)|false|none||none|
|limit|integer(int32)|false|none||none|
|page|integer(int32)|false|none||none|
|parentCommentId|integer(int64)|false|none||none|
|topicId|integer(int64)|false|none||none|
|twoLimit|integer(int32)|false|none||none|
|twoPage|integer(int32)|false|none||none|

