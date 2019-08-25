FROM agencyicole/runtime:1.0.0

COPY target/classes /app
COPY target/lib /app/lib

CMD ["/bin/bash","cd /app; java -cp .:lib\*.jar com.example.demo.DemoApplication"]

