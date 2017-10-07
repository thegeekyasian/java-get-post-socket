# java-get-post-socket
Implementation of GET and POST requests using Sockets in Java. I am an Apache lover but I had a small project that was specified to use Sockets and not even HttpURLConnection and it took me a lot of time since I couldn't fine any working links. Here is a small piece of example code that I am sharing with you guys. An example of POST and GET requests in Java using Sockets. Comments and feedback is appreciated.

There are two classes in the repository, located in src/com.thegeekyasian/
1. Main.java
2. HttpClient.java

HttpClient.java is a self created client example of how to use GET or POST methods in java usings sockets.
The class contains two methods:
a. sendGetRequest(String url);
b. sendPostRequest(String url, data);

Both the methods return the response in a form of Map<String, String>, where the Main.java class accesses each of these returning results and print them on the screen.

The url that I have used for GET request is "http://httpbin.org/get?author=The+Geeky+Asian&course=GET+Request+Using+Sockets+in+Java".
Here is the output of the above url when sent as a parameter in sendGetRequest(url) method:

Header: 
HTTP/1.1 200 OK
Connection: close
Server: meinheld/0.6.1
Date: Sat, 07 Oct 2017 22:28:25 GMT
Content-Type: application/json
Access-Control-Allow-Origin: *
Access-Control-Allow-Credentials: true
X-Powered-By: Flask
X-Processed-Time: 0.000712871551514
Content-Length: 309
Via: 1.1 vegur

Content: 
{
  "args": {
    "author": "The Geeky Asian", 
    "course": "GET Request Using Sockets in Java"
  }, 
  "headers": {
    "Connection": "close", 
    "Host": "httpbin.org"
  }, 
  "origin": "39.50.255.191", 
  "url": "http://httpbin.org/get?author=The+Geeky+Asian&course=GET+Request+Using+Sockets+in+Java"
}

Moving to the POST request, I used "http://httpbin.org/post" as a url in parameters of sentPostRequest(url, data) method along with a json payload as follows:
{
    "author": "The Geeky Asian", 
    "course": "POST Request Using Sockets in Java"
}

Here is the result:
{
  "args": {}, 
  "data": "{\"author\" : \"The Geeky Asian\",\"course\" : \"POST Request Using Sockets in Java\"}", 
  "files": {}, 
  "form": {}, 
  "headers": {
    "Connection": "close", 
    "Content-Length": "78", 
    "Host": "httpbin.org"
  }, 
  "json": {
    "author": "The Geeky Asian", 
    "course": "POST Request Using Sockets in Java"
  }, 
  "origin": "xx.xx.xxx.xxx", 
  "url": "http://httpbin.org/post"
}

I hope this repo ended up helping you out with the understanding or whatever you were looking for.
Comments, feedback and criticism is most welcome.

Do not forget to like my page of Facebook: http://facebook.com/TheGeekyAsianOfficial/


