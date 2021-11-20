
-- Provide a query showing Customers (just their full names, customer ID and country) who are not in the US
SELECT "CustomerId", CONCAT("FirstName", ' ', "LastName") AS "Full name", "Country" 
FROM "Customer" 
WHERE "Country" != 'USA';

-- Provide a query only showing the Customers from Brazil
SELECT * 
FROM "Customer" 
WHERE "Country" = 'Brazil';

-- Provide a query showing the Invoices of customers who are from Brazil. 
-- The resultant table should show the customer’s full name, Invoice ID, Date of the invoice and billing country.
SELECT  CONCAT("FirstName",  ' ', "LastName") AS "Full name",  "Invoice"."InvoiceId", "Invoice"."InvoiceDate", "Invoice"."BillingCountry"  
FROM "Invoice" 
LEFT JOIN "Customer" 
ON "Invoice"."CustomerId"="Customer"."CustomerId" 
WHERE "Customer"."Country" = 'Brazil';

-- Provide a query showing only the Employees who are Sales Agents.
SELECT * 
FROM "Employee" 
WHERE "Title"='Sales Support Agent';

-- Provide a query showing a unique list of billing countries from the Invoice table
SELECT DISTINCT "Invoice"."BillingCountry" 
FROM "Invoice";

-- Provide a query that shows the invoices associated with each sales agent.
-- The resultant table should include the Sales Agent’s full name.
SELECT "Invoice".*, CONCAT("Employee"."FirstName", ' ', "Employee"."LastName") AS "Full name" 
FROM "Invoice" 
LEFT JOIN "Customer" 
ON "Invoice"."CustomerId"="Customer"."CustomerId" 
LEFT JOIN "Employee" 
ON "Customer"."SupportRepId"="Employee"."EmployeeId";

-- Provide a query that shows the Invoice Total, Customer name, Country and Sale Agent name for all invoices and customers
SELECT DISTINCT  "Invoice"."Total",  "Customer"."FirstName", "Customer"."Country", "Employee"."FirstName" 
FROM "Invoice" 
LEFT JOIN "Customer" 
ON "Invoice"."CustomerId"="Customer"."CustomerId" 
LEFT JOIN "Employee" 
ON "Customer"."SupportRepId"="Employee"."EmployeeId";


-- How many Invoices were there in 2009 and 2011? 
SELECT * 
FROM "Invoice" 
WHERE "InvoiceDate" BETWEEN '2009-01-01' AND '2009-12-31'
UNION (
SELECT * 
FROM "Invoice" 
WHERE "InvoiceDate" BETWEEN '2011-01-01' AND '2011-12-31');

-- What are the respective total sales for each of those years?
SELECT SUM("Total")
FROM "Invoice" 
WHERE "InvoiceDate" 
BETWEEN '2009-01-01' AND '2009-12-31'
UNION(
SELECT SUM("Total")
FROM "Invoice" 
WHERE "InvoiceDate" 
BETWEEN '2011-01-01' AND '2011-12-31');

SELECT SUM("Total"), EXTRACT(YEAR FROM "InvoiceDate") AS year
FROM "Invoice" 
WHERE "InvoiceDate"
BETWEEN '2009-01-01' AND '2011-12-31' AND EXTRACT(YEAR FROM "InvoiceDate") != '2010'
GROUP BY year;


-- Looking at the InvoiceLine table, provide a query that COUNTs the number of line items for Invoice ID 37
SELECT COUNT("InvoiceLine") 
FROM "InvoiceLine" 
WHERE "InvoiceId"=37;

-- Looking at the InvoiceLine table, provide a query that COUNTs the number of line items for each Invoice. HINT: GROUP BY
SELECT "InvoiceId", COUNT("InvoiceId") 
FROM "InvoiceLine" 
GROUP BY "InvoiceId";

