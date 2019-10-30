### **oauth2_server说明文档<br>**

###### 获取token_access

密码模式:  
`http://localhost:8080/oauth/token?username=user_1&password=123456grant_type=password&scope=select&client_id=client_2&client_secret=123456  
`得到返回值:  
`{"access_token":"9c11dd46-efdd-41b2-9928-4579b3d80390","token_type":"bearer","refresh_token":"4c828c4f-16a8-4c45-97b3-e896845aa555","expires_in":43199,"scope":"select"}`  
客户端模式:  
`http://localhost:8080/oauth/token?grant_type=client_credentials&scope=selectclient_id=client_1&client_secret=123456`  
得到返回值:  
`{"access_token":"7dd1ea47-b817-4060-aee2-a95ea3c4b3d9","token_type":"bearer","expires_in":43199,"scope":"select"}`  
访问`http://localhost:8080/order/1`  被保护  
```$xslt
<oauth>
<error_description>
Full authentication is required to access this resource
</error_description>
<error>unauthorized</error>
</oauth>
```
访问`http://localhost:8080/product/1`没有被保护,返回`1 `   
token刷新:  
客户端模式无法刷新,密码模式可以刷新  
your_refresh_token:为password模式下面的4c828c4f-16a8-4c45-97b3-e896845aa555  
刷新token_access链接:`http://localhost:8080/oauth/token?grant_type=refresh_token&refresh_token=your_refresh_token&client_id=client_2&client_secret=123456`
