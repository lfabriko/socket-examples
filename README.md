# Socket examples in java
Blocking:
- to simulate multiple servers and clients, run subsequently [MainServers](src/blocking/MainServers.java) and [MainClients](src/blocking/MainClients.java)
- created via [Writing the Server Side of a Socket](https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html)
- output: (e.g. client `C1` sent message `aa`, was server by server `S1`)
```
C1 response: aa sent-by-C1-echoed-by-S1
C2 response: 10 sent-by-C2-echoed-by-S0
...
```

Nonblocking:
- to simulate server processing multiple clients with Selector, run subsequently [MainEchoServer](src/nonblocking/MainEchoServer.java) and [MainClients](src/nonblocking/MainClients.java)
- created via [What Is Non-blocking Socket Programming in Java?](https://www.developer.com/java/data/what-is-non-blocking-socket-programming-in-java/)
- output: (e.g. client `C1` sent message `aa`, client `C2` sent `10`)
```
response: 10
response: aa
...
```
