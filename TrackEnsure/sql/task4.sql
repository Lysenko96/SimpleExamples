-- Provide a query that shows the # of customers assigned to each sales agent
SELECT "Customer"."CustomerId", "Employee".* FROM "Customer" INNER JOIN "Employee" ON "Customer"."SupportRepId"="Employee"."EmployeeId";

-- Provide a query that shows the total sales per country.
SELECT "BillingCountry",  SUM("Total") FROM "Invoice" GROUP BY "BillingCountry";

-- Which country’s customers spent the most?
SELECT "BillingCountry", COUNT("BillingCountry") AS countryCount FROM "Invoice" GROUP BY "BillingCountry";

SELECT MAX(query.countryCount) FROM ( SELECT COUNT("BillingCountry") AS countryCount FROM "Invoice" GROUP BY "BillingCountry") query;

-- Provide a query that shows the most purchased track of 2013

SELECT "InvoiceLine".* FROM "InvoiceLine" INNER JOIN "Invoice" ON "InvoiceLine"."InvoiceId"="Invoice"."InvoiceId"
WHERE "InvoiceDate" BETWEEN '2013-01-01' AND '2013-12-12';

--Provide a query that shows the top 5 most purchased tracks over all.
SELECT "InvoiceLine".* FROM "InvoiceLine" INNER JOIN "Invoice" ON "InvoiceLine"."InvoiceId"="Invoice"."InvoiceId";

--Provide a query that shows the top 3 best selling artists
SELECT COUNT("Artist"."Name"), "Artist"."Name" FROM "Track" INNER JOIN "Album" ON "Track"."AlbumId"="Album"."AlbumId" INNER JOIN "Artist" ON "Album"."ArtistId"="Artist"."ArtistId"
GROUP BY "Artist"."Name", "Artist"."Name" ORDER BY COUNT("Artist"."Name") DESC ;

-- Provide a query that shows the most purchased Media Type.
 SELECT COUNT("MediaTypeId"), "MediaTypeId" FROM "Track" GROUP BY "MediaTypeId";