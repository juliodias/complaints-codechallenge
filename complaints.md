**Create Complaint:**

http://localhost:8080/complaints

```json
{  
   "title":"A Empresa nao entregou minha encomenda",
   "description":"Esperando minha encomenda faz 1 mes.",
   "company":{  
      "name":"Umbrella Corporation"
   },
   "address":{  
      "city":"Sao Paulo",
      "state":"SP"
   }
}
```

**Find All Complaints:**
http://localhost:8080/complaints

**Find specific Complaint:**
http://localhost:8080/complaints/id

**Find All Complaints by title:** 
http://localhost:8080/complaints/search/titles?title=

**Find All Complaints by city:**
http://localhost:8080/complaints/search/cities?city=

**Find All Complaints by state:**
http://localhost:8080/complaints/search/states?state=

**Find All Complaints by company:**
http://localhost:8080/complaints/search/companies?name=

**Find All Complaints by company and city:**
http://localhost:8080/complaints/search/companiesByCity?name=&city=

All methods has: _size, page and sort params._
If you running the Gateway API, please, change http://localhost:8080/complaints to http://localhost:9090/complaint-service and use the following basic auth credentials:

**username:** api
**password:** 123
