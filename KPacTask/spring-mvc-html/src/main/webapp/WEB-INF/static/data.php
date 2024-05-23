<?php
require_once("../static/codebase/connector/grid_connector.php"); // includes the appropriate connector file

$res = new PDO("mysql:dbname=k_pac;host=localhost","root","root");
$conn = new GridConnector($res,"MySQL");                // connector initialization

$conn->render_table("k_pac","id","title,description,createdAt");
