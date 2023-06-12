# 前期准备与安装环境

## node环境

`node`版本: 16.12.0 `node -v`

`npm`版本: 8.1.0 `npm -v`

搭建`vue-element-template`模板, [官方文档](https://panjiachen.github.io/vue-element-admin-site/zh/guide/)
前置技术栈为`vue`和`element-ui`

解压`vue-element-template`模板时需要注意, 必须解压所在路径不能有**中文字符和空格**

进入前端目录(package.json同目录)后进入命令行(管理员权限), 为`npm`设置镜像: `npm config set registry http://registry.npm.taobao.org` 然后安装依赖 `npm install`

如果使用淘宝的镜像还是太慢并导致安装依赖失败, 可以考虑使用淘宝镜像站提供的`cnpm`

首先安装`cnpm`: `npm install -g cnpm`, 然后使用这个来安装依赖`cnpm install`

所有的依赖安装完后开始运行开发环境: `npm run dev`

替换端口号,在`vue.config.js`中修改

```js
const port = process.env.port || process.env.npm_config_port || ???? // 修改成你想要的端口
```

每次运行开发环境会自动打开浏览器, 烦内, 修改成`open: false;`

关闭语法纠错机制,这样系统就不会在缩进上烦人了, `lintOnSave: false,`

```js
// lintOnSave: process.env.NODE_ENV === 'development',
  lintOnSave: false,
  productionSourceMap: false,
  devServer: {
    port: port,
    open: false,
    overlay: {
      warnings: false,
      errors: true
    },
    before: require('./mock/mock-server.js')
  },
```

在`src\settings.js`目录下可以修改title

## SpringBoot环境

JDK版本: 1.8

SpringBoot框架版本: 2.7.8

所需依赖:

* `spring-boot-starter-web`
* `mysql-connector-j`
* `mybatis-plus-boot-starter`, 版本: 3.5.2
* `mybatis-plus-generator`, 版本: 3.5.2
* `freemarker`
* `lombok`
* `pring-boot-starter-data-redis`
* `spring-boot-starter`
* `spring-boot-starter-test`
* `fastjson2`, 版本: 2.0.7
* `spring-security-core`
* `spring-security-core`

## Element UI

版本：2.13.2

[官方文档](https://element.eleme.cn/#/zh-CN)
