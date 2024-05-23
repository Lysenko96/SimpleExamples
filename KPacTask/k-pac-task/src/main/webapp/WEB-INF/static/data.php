<?php
require_once("codebase/connector/grid_connector.php"); // includes the appropriate connector file

$res=mysql_connect("localhost","root","root");                  //connects to a server that contains the desired DB
mysql_select_db("k_pac");                                // connects to the DB. 'sampledb' is the name of our DB
$conn = new GridConnector($res,"MySQL");                    // connector initialization

$conn->render_table("k_pac","id","title,description,creation date");   // data configuration
