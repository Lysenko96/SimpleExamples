-- Provide a query that includes the track name with each invoice line item
SELECT "Track"."Name", "InvoiceLine".* FROM "InvoiceLine" INNER JOIN "Track" ON "InvoiceLine"."TrackId"="Track"."TrackId";

-- Provide a query that includes the purchased track name AND artist name with each invoice line item.
SELECT "InvoiceLine".*, "Track"."Name", "Artist"."Name"  FROM "InvoiceLine" INNER JOIN "Track" ON "InvoiceLine"."TrackId"="Track"."TrackId" INNER JOIN "Album" ON "Track"."AlbumId"="Album"."AlbumId" INNER JOIN "Artist" ON "Album"."ArtistId"="Artist"."ArtistId";


-- Provide a query that shows the # of invoices per country. HINT: GROUP BY
SELECT COUNT("InvoiceId"), "BillingCountry" FROM "Invoice" GROUP BY "BillingCountry";

-- Provide a query that shows the total number of tracks in each playlist. 
-- The Playlist name should be included on the resultant table
SELECT "Playlist"."Name", COUNT("PlaylistTrack"."PlaylistId") FROM "PlaylistTrack" INNER JOIN "Playlist" ON "PlaylistTrack"."PlaylistId"="Playlist"."PlaylistId"  GROUP BY "PlaylistTrack"."PlaylistId", "Playlist"."Name";

-- Provide a query that shows all the Tracks, but displays no IDs. 
-- The resultant table should include the Album name, Media type and Genre
SELECT DISTINCT "Track"."Name", "Album"."Title", "MediaType"."Name", "Genre"."Name" FROM "Track" INNER JOIN "Album" ON "Track"."AlbumId"="Album"."AlbumId" INNER JOIN "MediaType" ON "Track"."MediaTypeId"="MediaType"."MediaTypeId" INNER JOIN "Genre" ON "Track"."GenreId"="Genre"."GenreId";

-- Provide a query that shows all Invoices but includes the # of invoice line items
SELECT "InvoiceLine"."InvoiceLineId", "Invoice".* FROM "InvoiceLine" INNER JOIN "Invoice" ON "InvoiceLine"."InvoiceId"="Invoice"."InvoiceId";

-- Provide a query that shows total sales made by each sales agent.
--SELECT COUNT("Customer"."SupportRepId"), "Employee"."FirstName", "Employee"."LastName" FROM "Customer" INNER JOIN "Employee" ON "Customer"."SupportRepId"="Employee"."EmployeeId" GROUP BY "Customer"."SupportRepId", "Employee"."FirstName", "Employee"."LastName";

SELECT "Customer"."SupportRepId", COUNT("Customer"."SupportRepId") FROM "Invoice" INNER JOIN "Customer" ON "Invoice"."CustomerId"="Customer"."CustomerId" GROUP BY "Customer"."SupportRepId";


-- Which sales agent made the most in sales in 2009?
 
--SELECT DISTINCT "Customer"."SupportRepId", SUM("Invoice"."Total") FROM "Invoice", "Customer" INNER JOIN "Employee" ON "Customer"."SupportRepId"="Employee"."EmployeeId" WHERE "InvoiceDate" BETWEEN '2009-01-01' AND '2009-12-12' GROUP BY "Customer"."SupportRepId", "Invoice"."InvoiceId", "Employee"."EmployeeId";

SELECT "Customer"."SupportRepId", SUM("Invoice"."Total") FROM "Invoice", "Customer" INNER JOIN "Employee" ON "Customer"."SupportRepId"="Employee"."EmployeeId" WHERE "InvoiceDate" BETWEEN '2009-01-01' AND '2009-12-12' GROUP BY "Customer"."SupportRepId", "Employee"."EmployeeId";


-- Which sales agent made the most in sales in 2010?

--SELECT DISTINCT "Customer"."SupportRepId", SUM("Invoice"."Total") FROM "Invoice", "Customer" INNER JOIN "Employee" ON "Customer"."SupportRepId"="Employee"."EmployeeId" WHERE "InvoiceDate" BETWEEN '2010-01-01' AND '2010-12-12' GROUP BY "Customer"."SupportRepId", "Invoice"."InvoiceId", "Employee"."EmployeeId";

SELECT "Customer"."SupportRepId", SUM("Invoice"."Total") FROM "Invoice", "Customer" INNER JOIN "Employee" ON "Customer"."SupportRepId"="Employee"."EmployeeId" WHERE "InvoiceDate" BETWEEN '2009-01-01' AND '2009-12-12' GROUP BY "Customer"."SupportRepId", "Employee"."EmployeeId";

-- test max

SELECT MAX(sumTotal) FROM(SELECT "Employee"."EmployeeId", SUM("Invoice"."Total") AS sumTotal FROM "Invoice", "Customer" INNER JOIN "Employee" ON "Customer"."SupportRepId"="Employee"."EmployeeId" WHERE "InvoiceDate" BETWEEN '2009-01-01' AND '2009-12-12' GROUP BY "Employee"."EmployeeId") query ;


-- Which sales agent made the most in sales over all?

-- SELECT "Customer"."SupportRepId", SUM("Invoice"."Total")  FROM "Invoice", "Customer" INNER JOIN "Employee" ON "Customer"."SupportRepId"="Employee"."EmployeeId" GROUP BY "Customer"."SupportRepId", "Employee"."EmployeeId";

SELECT "Customer"."SupportRepId", SUM("Invoice"."Total")  FROM "Invoice" INNER JOIN "Customer" ON "Invoice"."CustomerId"="Customer"."CustomerId" GROUP BY "Customer"."SupportRepId";






