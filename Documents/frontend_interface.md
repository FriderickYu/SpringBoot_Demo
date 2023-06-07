# 前后端接口文档

## 接口: 登录

URL: user/login

METHOD: POST

Request Body Sample:

```json
{username: "admin", password: "111111"}
```

Response Body Sample: 
```json
{"code":20000,
  "data":
  {"token":"admin-token"}
}
```
## 接口: 用户登录后根据token值获得对应信息

URL: user/info?token=???

METHOD: GET

Parameter Sample: 

```json
user/info?token=admin-token
token=admin-token
```

Response Body Sample:
```json
{
  "code": 20000,
  "data": {
    "roles": [
      "admin"
    ],
    "introduction": "I am a super administrator",
    "avatar": "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
    "name": "Super Admin"
  }
}
```

## 接口: 退出

URL: user/logout

METHOD: POST

Response Body Sample:
```json
{"code":20000,
  "data":"success"
}
```