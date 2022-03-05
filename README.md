# casesproject

This is a small demonstration of springboot rest to simulate operations in an in-memory database.

These are very basic operations like create Cases, using JSON data. operations such as register user, 
get cases by status, get cases by user Id,  get cases by status and user Id, get cases by Id, creation of cases
and addition of notes for specified case.

I used PostMan application for these operations, which are very simple.

 - Endpoint for registering user:
    http://localhost:8080/api/cases/user/register
    
    Data:
    {
	    "firstName": "Ederson",
	    "lastName": "Santos",
	    "email": "edersonjsed@gmail.com"
    }

 - Endpoint for adding cases:
   http://localhost:8080/api/cases/create
   
   Data:
   {
	    "title": "New Case",
	    "description": "Case for test",
	    "severity": "2",
	    "status": "Open",
	    "noteDetail": "Details for notes",
	    "userEmail": "edersonjsed@gmail.com"
   }
   {
       "title": "Another Case",
       "description": "Case for others",
       "severity": "3",
       "status": "Closed",
       "noteDetail": "Details for Two notes",
       "userEmail": "edersonjsed@gmail.com"
    }

 - Endpoint for fetching cases by status:
  http://localhost:8080/api/cases/status/{status}
  
 - Endpoint for fetching cases by user Id
  http://localhost:8080/api/cases/user/{userId}
  
 - Endpoint for fetching cases by user Id and status:
  http://localhost:8080/api/cases/user/{userId}/status/{status}
  
 - Endpoint for fetching case by Id:
  http://localhost:8080/api/cases/{caseId}
  
 - Endpoint to add note to specified case:
  http://localhost:8080/api/case/{caseId}/addNote 
  
  Data is in plain text
