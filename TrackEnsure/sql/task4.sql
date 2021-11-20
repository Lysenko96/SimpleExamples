-- Provide a query that shows the # of customers assigned to each sales agent 
SELECT COUNT("CustomerId"), "SupportRepId"
FROM "Customer"
GROUP BY "SupportRepId";

-- Provide a query that shows the total sales per country.
SELECT "BillingCountry",  SUM("Total") 
FROM "Invoice" 
GROUP BY "BillingCountry";

-- Which country’s customers spent the most?

SELECT "BillingCountry", SUM("Total") AS total
FROM "Invoice"
GROUP BY "BillingCountry" ORDER BY total DESC
LIMIT 1;

--frequency country
--SELECT "BillingCountry", COUNT("BillingCountry") AS countryCount 
--FROM "Invoice" GROUP BY "BillingCountry" ORDER BY countryCount DESC
--LIMIT 1;
--max frequency country
--SELECT MAX(query.countryCount) FROM ( SELECT COUNT("BillingCountry") AS countryCount FROM "Invoice" GROUP BY "BillingCountry") query;

-- Provide a query that shows the most purchased track of 2013

-- find most counter InvoiceId from InvoiceLine

SELECT "Invoice"."InvoiceId"
FROM "InvoiceLine" 
INNER JOIN "Invoice"
ON "InvoiceLine"."InvoiceId"="Invoice"."InvoiceId"
WHERE "InvoiceDate" BETWEEN '2013-01-01' AND '2013-12-31'
GROUP BY "Invoice"."InvoiceId" ORDER BY COUNT("InvoiceLine"."InvoiceId") DESC
LIMIT 1;

-- find track for InvoiceId

SELECT "Track".*
FROM "InvoiceLine"
INNER JOIN "Track"
ON "InvoiceLine"."TrackId"="Track"."TrackId"
WHERE "InvoiceId" = (SELECT "Invoice"."InvoiceId"
FROM "InvoiceLine" 
INNER JOIN "Invoice"
ON "InvoiceLine"."InvoiceId"="Invoice"."InvoiceId"
WHERE "InvoiceDate" BETWEEN '2013-01-01' AND '2013-12-31'
GROUP BY "Invoice"."InvoiceId" ORDER BY COUNT("InvoiceLine"."InvoiceId") DESC
LIMIT 1)
LIMIT 1;


--Provide a query that shows the top 5 most purchased tracks over all.
SELECT "Track".*
FROM "InvoiceLine"
INNER JOIN "Track"
ON "InvoiceLine"."TrackId"="Track"."TrackId"
WHERE "InvoiceId" = (SELECT "Invoice"."InvoiceId"
FROM "InvoiceLine" 
INNER JOIN "Invoice"
ON "InvoiceLine"."InvoiceId"="Invoice"."InvoiceId"
GROUP BY "Invoice"."InvoiceId" ORDER BY COUNT("InvoiceLine"."InvoiceId") DESC
LIMIT 1)
LIMIT 5;

--Provide a query that shows the top 3 best selling artists +/-
SELECT "Invoice"."InvoiceId"
FROM "Invoice"
GROUP BY "Invoice"."InvoiceId" ORDER BY SUM("Invoice"."Total") DESC
LIMIT 3;

--- from invoice 3 customer sum total max
--- from invoiceLine track for 3 customer with sum total max
--- from track 3 artist

SELECT DISTINCT "Artist".* 
FROM "Track"
INNER JOIN "Album"
ON "Track"."AlbumId"="Album"."AlbumId"
INNER JOIN "Artist"
ON "Album"."ArtistId"="Artist"."ArtistId" 
WHERE "Track"."TrackId"
IN
(SELECT "InvoiceLine"."TrackId"
FROM "InvoiceLine"
WHERE "InvoiceLine"."InvoiceId" IN (SELECT "Invoice"."CustomerId"
FROM "Invoice"
GROUP BY "Invoice"."InvoiceId" ORDER BY SUM("Invoice"."Total") DESC
LIMIT 3) ORDER BY "Quantity" DESC)
LIMIT 3;

-- Provide a query that shows the most purchased Media Type. 
 SELECT COUNT("MediaTypeId"), "MediaTypeId" 
 FROM "Track" 
 GROUP BY "MediaTypeId";
 
 
 
 
 