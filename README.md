# AgData API Challenge

## Getting Started

1. **Accept the GitHub Classroom assignment**  
   By accepting this assignment, you'll create your own copy of this repository.

2. **Clone your repository**  
   Once you've accepted the assignment, clone your new repository to your local machine using:
   ```
   git clone [your-repository-url]
   ```

3. **Open the project in your IDE**  
   Import the project as a Maven project in your preferred IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

## Challenge Overview

In this assignment, you'll implement a Spring Boot REST API that processes and analyzes agricultural data. The application will parse a provided JSON dataset of crop records and expose endpoints to query this data.

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

The project includes test cases in `AgDataServiceTest.java` that you can use to validate your implementation. Make sure all tests pass before submitting.

Run the tests with:
```
mvn test
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
   git push origin main
   ```

2. Verify that your changes have been pushed to GitHub

Your submission will be automatically recorded when you push to your repository before the deadline.

Good luck!
