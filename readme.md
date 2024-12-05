Minimum Spanning Tree (MST) Application
📚 Overview
This project is a console-based application designed to calculate the Minimum Spanning Tree (MST) for a set of European capitals based on distances provided in a dataset. The application leverages Kotlin programming language and employs Kruskal's Algorithm for graph processing.

🚀 Features
Dynamic Data Loading: Load city distance data from a file (e.g., distances.txt).
MST Calculation: Compute the optimal MST and display connections with their distances and total length.
Interactive Menu: A simple and intuitive console-based interface for users to choose actions.
🛠️ How to Use
Clone the repository to your local machine:
bash
Copy code
git clone https://github.com/your-username/mst-application.git
cd mst-application
Ensure Kotlin is installed. Follow the official installation guide if needed.
Place the dataset file (e.g., distances.txt) in the root directory.
Compile and run the program:
bash
Copy code
kotlinc Main.kt -include-runtime -d Main.jar
java -jar Main.jar
Use the menu to:
Load the dataset.
Calculate the MST.
Exit the program.
📂 Example Dataset Format
Ensure the dataset file follows this structure:

python
Copy code
City1, City2, Distance
Amsterdam, Berlin, 577
Amsterdam, Brussels, 173
...
💡 Example Usage
Loading Data:
csharp
Copy code
Enter the file name (e.g., distances.txt): distances.txt
Data loaded successfully from distances.txt.
Calculating MST:
mathematica
Copy code
Calculating Minimum Spanning Tree (MST)...
Minimum Spanning Tree:
Amsterdam - Brussels: 173 km
Berlin - Amsterdam: 577 km
Total Cable Length Required: 750 km
🌟 Key Classes
Graph: Core logic for graph representation, file loading, and MST calculation.
Edge: Represents a connection between two cities with a distance.
City: Represents a city in the dataset.
Main: Handles user interaction via the console and coordinates program execution.
🔧 Challenges
Managing large datasets and ensuring accurate parsing.
Debugging edge cases in Kruskal's algorithm, such as disconnected graphs or duplicate edges.
Optimizing performance for processing large graphs.
🎯 Lessons Learned
Importance of consistent data formatting for reliable results.
Effective use of Kotlin’s language features for clean and modular code.
Enhanced understanding of graph algorithms and their real-world applications.
📜 License
This project is open-source and available under the MIT License.

👤 Author
Davide Ningbahouot - Developer of this MST Application.
