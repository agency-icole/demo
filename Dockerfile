FROM agencyicole/runtime:1.0.0

COPY target/classes /app
COPY target/lib /app/lib

CMD cd /app; java -cp .:lib/* com.example.demo.DemoApplication

