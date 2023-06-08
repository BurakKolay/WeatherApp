
# Weather Application

In this project, a weather application was developed that provides weather forecasts using a RESTful web service. Users can query and save weather forecasts for cities. The application retrieves weather forecast data from the OpenWeatherMap API.

## Features
- Allows users to query weather forecasts for their cities.
- Provides weather forecasts in 3-hour intervals covering a 5-day period.
- Users can create an account to save their cities and view weather forecasts for the saved cities.

## Technologies Used
- **SpringBoot:** Used for application development and providing RESTful services
- **JWT Security:** Used for authentication and authorization using JSON Web Tokens.
- **PostgreSQL:** Database used to fetch the users, the cities the user saved and the weather for the cities they saved
- **MongoDB:** To set up the logging mechanism
- **Kafka:** Provides messaging so that the logging mechanism can be made
- **Exception Handler:** Mechanism used to catch and handle exceptions within the application
- **API Gateway:** Used for routing and managing API requests.
- **Eureka Server:** Service discovery server for microservices architecture.
- **Mockito:** Framework used for unit testing and mocking dependencies.
- **Docker:** Containerization platform used for packaging the application and its dependencies.
## Installation

- Clone the project repository

```bash
  git clone https://github.com/BurakKolay/WeatherApp
```
- Install the required dependencies by running the following command
```bash
  mvn install
```
- Run docker-compose.yml
```bash
  docker-compose up -d
```
- Start the application by running the following command  
```bash
  mvn spring-boot:run
```
- Once the application is successfully started, you can access the application by navigating to http://localhost:8761 in your browser.

## Configuration
- **application.properties:** Used for configuring connections to PostgreSQL, Kafka, MongoDB, and other application settings.
## API Reference

#### Register

```http
  POST http://localhost:9010/weather-service/api/v1/auth/register
```

| Parameter | Type     |   Description                |
| :-------- | :------- | :------------------------- |
| `RegisterDTO` | `object` | **Required**. Your account |

#### Authenticate

```http
  GET http://localhost:9010/weather-service/api/v1/auth/authenticate
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `AuthDTO`      | `object` | **Required**. username and password |


#### Get Weather

```http
  POST http://localhost:9010/weather-service/api/v1/weather?city={city}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `city`      | `String` | **Required**. City name |



#### Add weather for user

```http
  POST http://localhost:9010/weather-service/api/v1/user/{city}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `city`      | `String` | **Required**. City name |



#### Get All Logs

```http
  GET http://localhost:9010/log-service/api/v1/log
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `no parameter`      | `none` | **None**. |


#### Get Log By Id

```http
  GET http://localhost:9010/log-service/api/v1/log/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `String` | **Required**. Log id|

#### Delete Log By Id

```http
  DELETE http://localhost:9010/log-service/api/v1/log/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `String` | **Required**. Log id|