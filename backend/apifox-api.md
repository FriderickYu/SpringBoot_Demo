# <p>

<p>
 前端控制器
</p>


---
## getAllUser

> BASIC

**Path:** /user/all

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer |  |
| message | string |  |
| data | array |  |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─username | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─password | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─email | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─phone | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─status | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─avatar | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─deleted | integer |  |

**Response Demo:**

```json
{
  "code": 0,
  "message": "",
  "data": [
    {
      "id": 0,
      "username": "",
      "password": "",
      "email": "",
      "phone": "",
      "status": 0,
      "avatar": "",
      "deleted": 0
    }
  ]
}
```




---
## login

> BASIC

**Path:** /user/login

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| username | string |  |
| password | string |  |
| email | string |  |
| phone | string |  |
| status | integer |  |
| avatar | string |  |
| deleted | integer |  |

**Request Demo:**

```json
{
  "id": 0,
  "username": "",
  "password": "",
  "email": "",
  "phone": "",
  "status": 0,
  "avatar": "",
  "deleted": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer |  |
| message | string |  |
| data | object |  |
| &ensp;&ensp;&#124;─key | object |  |

**Response Demo:**

```json
{
  "code": 0,
  "message": "",
  "data": {
    "": {}
  }
}
```




---
## getUserInfo

> BASIC

**Path:** /user/info

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| token |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer |  |
| message | string |  |
| data | object |  |
| &ensp;&ensp;&#124;─key | object |  |

**Response Demo:**

```json
{
  "code": 0,
  "message": "",
  "data": {
    "": {}
  }
}
```




---
## logout

> BASIC

**Path:** /user/logout

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| X-Token |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer |  |
| message | string |  |
| data | object |  |

**Response Demo:**

```json
{
  "code": 0,
  "message": "",
  "data": null
}
```




---
## getUserList

> BASIC

**Path:** /user/list

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| username |  | NO |  |
| phone |  | NO |  |
| pageNo |  | YES |  |
| pageSize |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer |  |
| message | string |  |
| data | object |  |
| &ensp;&ensp;&#124;─key | object |  |

**Response Demo:**

```json
{
  "code": 0,
  "message": "",
  "data": {
    "": {}
  }
}
```




---
## addUser

> BASIC

**Path:** /user

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| username | string |  |
| password | string |  |
| email | string |  |
| phone | string |  |
| status | integer |  |
| avatar | string |  |
| deleted | integer |  |

**Request Demo:**

```json
{
  "id": 0,
  "username": "",
  "password": "",
  "email": "",
  "phone": "",
  "status": 0,
  "avatar": "",
  "deleted": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer |  |
| message | string |  |
| data | object |  |

**Response Demo:**

```json
{
  "code": 0,
  "message": "",
  "data": null
}
```




---
## updateUser

> BASIC

**Path:** /user

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| username | string |  |
| password | string |  |
| email | string |  |
| phone | string |  |
| status | integer |  |
| avatar | string |  |
| deleted | integer |  |

**Request Demo:**

```json
{
  "id": 0,
  "username": "",
  "password": "",
  "email": "",
  "phone": "",
  "status": 0,
  "avatar": "",
  "deleted": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer |  |
| message | string |  |
| data | object |  |

**Response Demo:**

```json
{
  "code": 0,
  "message": "",
  "data": null
}
```




---
## getUserById

> BASIC

**Path:** /user/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer |  |
| message | string |  |
| data | object |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─username | string |  |
| &ensp;&ensp;&#124;─password | string |  |
| &ensp;&ensp;&#124;─email | string |  |
| &ensp;&ensp;&#124;─phone | string |  |
| &ensp;&ensp;&#124;─status | integer |  |
| &ensp;&ensp;&#124;─avatar | string |  |
| &ensp;&ensp;&#124;─deleted | integer |  |

**Response Demo:**

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "username": "",
    "password": "",
    "email": "",
    "phone": "",
    "status": 0,
    "avatar": "",
    "deleted": 0
  }
}
```




---
## deleteUserById

> BASIC

**Path:** /user/{id}

**Method:** DELETE

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer |  |
| message | string |  |
| data | object |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─username | string |  |
| &ensp;&ensp;&#124;─password | string |  |
| &ensp;&ensp;&#124;─email | string |  |
| &ensp;&ensp;&#124;─phone | string |  |
| &ensp;&ensp;&#124;─status | integer |  |
| &ensp;&ensp;&#124;─avatar | string |  |
| &ensp;&ensp;&#124;─deleted | integer |  |

**Response Demo:**

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "username": "",
    "password": "",
    "email": "",
    "phone": "",
    "status": 0,
    "avatar": "",
    "deleted": 0
  }
}
```



