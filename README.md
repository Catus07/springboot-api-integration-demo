# springboot-api-integration-demo
 a Spring Boot application that demonstrates integration with different types of external APIs — public, API key–secured, and OAuth-style token systems.
 
- Public API (no authentication) — [JSONPlaceholder](https://jsonplaceholder.typicode.com/)
- API key–based authentication — [NewsAPI](https://newsapi.org/)
- OAuth-style token system — [PesaPal API](https://developer.pesapal.com/)

> Created by **Revocatus Joseph**  
> Clean code, clear error handling, and proper separation of concerns using Spring’s component model.

---
## Project Structure
com.dev.External_Api
├── config # Swagger/OpenAPI setup
├── controller # REST endpoints for each external API
├── model # POJOs for deserialized responses
├── service # Service classes with RestClient logic
└── ExternalApiApp # Main Spring Boot entry point


---

##  API Endpoints

### JSONPlaceholder (No Auth)
| Endpoint | Description |
|---------|-------------|
| `GET /api/v1/resource` | Get single post |
| `GET /api/v1/listing` | Get list of posts |

---

###  NewsAPI (API Key)
| Endpoint | Description |
|----------|-------------|
| `GET /api/v1/prod/news/{country}` | Get top headlines by country |
| `GET /api/v1/news/user/{name}` | Search top headlines by keyword |

---

###  Financial Modeling Prep API (API Key)
| Endpoint | Description |
|----------|-------------|
| `GET /api/v1/finance/data` | Get Apple (AAPL) stock info |
| `GET /api/v1/finance/search` | Search ticker symbol (e.g., "AA") |

---

###  PesaPal (OAuth-like Token)
| Endpoint | Description |
|----------|-------------|
| `POST /api/v1/token` | Request access token with `consumer_key` and `consumer_secret` |

---

##  Secure Your API Keys

###  How to Manage Secrets

1. Create your own `application.properties`:

```properties
newsapi.key=YOUR_NEWS_API_KEY
financialapi.key=YOUR_FINANCIAL_API_KEY
consumer.key=YOUR_PESAPAL_CONSUMER_KEY
consumer.secret=YOUR_PESAPAL_SECRET
pesapal.base.url=https://sandbox.pesapal.com

# Build and run
./mvnw spring-boot:run

Skills Demonstrated

 Spring Boot RestClient
 External API integration
 Clean error handling
 Configuration with @Value
 Token-based authentication
 API key usage
 OpenAPI/Swagger Documentation

 Contributions & Feedback

Feel free to fork, improve, or open issues. Feedback and suggestions are welcome!
