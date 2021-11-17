-- Provide a query that shows the # of customers assigned to each sales agent
SELECT "Customer"."CustomerId", "Employee".* FROM "Customer" INNER JOIN "Employee" ON "Customer"."SupportRepId"="Employee"."EmployeeId";

-- Provide a query that shows the total sales per country.
SELECT "BillingCountry",  SUM("Total") FROM "Invoice" GROUP BY "BillingCountry";

-- Which country’s customers spent the most?
SELECT "BillingCountry", COUNT("BillingCountry") AS countryCount FROM "Invoice" GROUP BY "BillingCountry";
SELECT MAX(query.countryCount) FROM ( SELECT COUNT("BillingCountry") AS countryCount FROM "Invoice" GROUP BY "BillingCountry") query;

-- Provide a query that shows the most purchased track of 2013
