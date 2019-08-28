FROM agencyicole/runtime:1.1

COPY target/classes /app
COPY target/lib /app/lib

CMD ["bash -c", "cd /app; java -cp .:lib/* com.example.demo.DemoApplication"]

