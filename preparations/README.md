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

cnpm install --save core-js/modules/es.array.push.js core-js/modules/es.error.cause.js core-js/modules/es.object.proto.js svg-baker-runtime/browser-symbol