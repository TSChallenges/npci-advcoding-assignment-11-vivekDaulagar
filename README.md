# AgData API Challenge
## Advanced Coding Assignment-11

### Problem Statement
In this assignment, you'll implement a Spring Boot REST API that processes and analyzes agricultural data. The application will parse a provided JSON dataset of crop records and expose endpoints to query this data.

### Steps to Follow
1. This GitHub repository will be accessible to you once you accept the Assignment.
2. You have to work directly in this GitHub repository. It is like your own copy of the original repository.

3. The folder structure is as given below: (showing major files only)
   ```
   root
   ├── pom.xml
   └── src
       └── main
       |  ├── java/com/agrichallenge/agdata
       |  |   ├── model
       |  |   |   └── AgData.java
       |  |   ├── controller
       |  |   |   └── AgDataController.java
       |  |   ├── service
       |  |   |   └── AgDataService.java
       |  |   └── AgDataApplication.java
       |  └── resources
       |      ├── data
       |      |   └── agdata.json
       |      ├── static
       |      |   └── index.html
       |      └── application.properties
       └── test
          └── java/com/agrichallenge/agdata
              └── AgDataApplicationTests.java
   ```

4. Review the code/comments present in above files to understand the structure.
5. Implement the missing classes/methods marked with **TODO** comments.
6. To work on the files, you can clone this GitHub repository onto your system and then open it with an IDE like IntelliJ, or Eclipse.
   ```
   git clone [your-repository-url]
   ```
8. Once done, push your changes to this remote GitHub repository.

### Files to Work On
- `src/main/java/com/agrichallenge/agdata/model/AgData.java`
- `src/main/java/com/agrichallenge/agdata/service/AgDataService.java`
- `src/main/java/com/agrichallenge/agdata/rest/AgDataController.java`


## Your Tasks

### 1. Create Model Classes
Design and implement the model classes needed to represent agricultural records and the dataset. The JSON structure is provided in `src/main/resources/data/agdata.json`.

### 2. Implement the Service Layer
Complete the `AgDataService` class with methods to:
- Count occurrences of a specific crop
- Calculate average yield for a crop
- Find all records from a specific region

### 3. Create the REST Controller
Implement a controller that exposes endpoints to access the service functionality:
- GET `/api/agdata/crop-count?cropName=corn`
- GET `/api/agdata/average-yield?cropName=wheat`
- GET `/api/agdata/by-region?region=Midwest`

### 4. Add Error Handling
Implement appropriate exception handling for your API.

## Testing Your Implementation

The project includes test cases in `AgDataApplicationTests.java` that you can use to validate your implementation. Make sure all tests pass before submitting.

Run the tests with:
```
mvn clean test
```

## Data Format

The application uses a dataset of agricultural records in the following format:
```json
{
  "records": [
    {
      "id": 1,
      "crop": "corn",
      "region": "Midwest",
      "yield": 180,
      "year": 2022
    },
    ...more records...
  ]
}
```

## Requirements

Your implementation should:
- Use proper Spring Boot conventions
- Include appropriate error handling
- Follow good coding practices (organization, naming, comments)
- Pass all the provided tests

## Submission

When you've completed the implementation:

1. Commit your changes to your repository:
   ```
   git add .
   git commit -m "Completed AgData API implementation"
   git push
   ```

2. Verify that your changes have been pushed to GitHub

Your submission will be automatically recorded when you push to your repository before the deadline.

## Grading Criteria:
- To implement `/api/agdata/crop-count` endpoint correctly [2 Marks]
- To implement `/api/agdata/average-yield` endpoint correctly [2 Marks]
- To implement `/api/agdata/by-region` endpoint correctly [2 Marks]
- To implement case insensitivity for query parameters [2 Marks]
- To implement appropriate exception handling for your API [2 Marks]

Good luck, and happy coding!
