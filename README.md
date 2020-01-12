# CQRS architecture (with DDD and command pattern)  with SpringBoot and Kotlin

Switch to "cqrs" branch to see how to refact from a classic architecture
to a cqrs one.



Run PhotographartApplication and try with : 

```
curl -X POST localhost:8080/arts -H "Content-Type: application/json" --data '{"art":":)","title":"happy guy", "description":"this is a smyley"}'
curl localhost:8080/arts/1
```
