##Spring Retry Demo project

build: `mvn package`

run: `java -jar retry-0.0.1-SNAPSHOT.jar`

use: 
* `curl localhost:8080/multiplier` - retry method call using x2 multiplying sleep interval (100 ms, 200 ms, 400 ms and so on)
* `curl localhost:8080/custom` - retry method call using custom sleep delay: first 5 attempts have 500 ms interval, afterwards - 1000 ms
