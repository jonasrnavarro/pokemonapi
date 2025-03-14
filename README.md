Name: Jonas Reuben V. Navarro

API Instruction Guide:

Step 1: Clone the repository
 1. git clone https://github.com/jonasrnavarro/pokemonapi.git
 2. cd pokemonapi
 
Step 2: Import the Project into IntelliJ
1. Open IntelliJ
2. Open the 'pokemonapi' folder
3. IntelliJ will automatically detect the project as Maven project.
4. Install dependencies.

Step 4: Run the application
1. Run PokemonapiApplication

Endpoints:
1. Fetch Pokemon by Name:
 URL: http://localhost:8080/pokemon/{name}
 Sample: http://localhost:8080/pokemon/wooper
 Sample response: {"id":194,"name":"wooper","types":["water","ground"],"moves":["ice-punch","slam","double-kick","headbutt"]}
2. Fetch Pokemon by ID:
 URL: http://localhost:8080/pokemon/id/{id}
 Sample: http://localhost:8080/pokemon/id/120
 Sample response: {"id":120,"name":"staryu","types":["water"],"moves":["headbutt","tackle","take-down","double-edge"]}

Thanks
