FROM agencyicole/runtime:1.1

COPY target/classes /app
COPY target/lib /app/lib

HEALTHCHECK --interval=5s --timeout=3s CMD wget -O http://localhost:8080/docker/health || exit 1
CMD java -cp .:lib/* com.example.demo.DemoApplication

