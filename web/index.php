<!DOCTYPE html>
<html>
<head>
    <title>Class Overview</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #007bff;
            color: #ffffff;
            text-align: center;
            padding: 10px 0;
        }

        #infoFrame {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            text-align: left;
            padding: 20px;
            margin: 20px auto;
            width: 80%;
        }

        h1 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        footer {
            background-color: #007bff;
            color: #ffffff;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <header>
        <h2>My School</h2>
    </header>

    <div id="infoFrame">
        <h1>Class</h1>

        <?php
        // Database connection settings
        $host = 'localhost:3306'; // or your host
        $username = 'root';
        $password = 'password';
        $database = 'db';

        // Create connection
        $conn = new mysqli($host, $username, $password, $database);

        // Check connection
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }

        $sql = "SELECT id, last_name, first_name FROM person"; // Adjusted to fetch id, last_name, and first_name
        $result = $conn->query($sql);

        if ($result->num_rows > 0) {
            // Start table
            echo "<table><tr><th>ID</th><th>Last Name</th><th>First Name</th></tr>";
            // Output data of each row
            while($row = $result->fetch_assoc()) {
                echo "<tr><td>" . $row["id"]. "</td><td>" . $row["last_name"]. "</td><td>" . $row["first_name"]. "</td></tr>";
            }
            echo "</table>";
        } elseif ($result->num_rows == 0) {
            echo "No students in class";
        } else {
            // This else part is technically not necessary since all conditions are covered above
        }
        $conn->close();
        ?>

    </div>

    <footer>
        <p>&copy; 2024 My School. All rights reserved.</p>
    </footer>
</body>
</html>
