-- Provide a query that includes the track name with each invoice line item
SELECT DISTINCT "Track"."Name", "Invoice".* FROM "Track","Invoice";

-- Provide a query that includes the purchased track name AND artist name with each invoice line item.
SELECT DISTINCT "Track"."Name", "Artist"."Name", "Invoice".* FROM "Track", "Artist","Invoice";

-- Provide a query that shows the # of invoices per country. HINT: GROUP BY
SELECT COUNT("InvoiceId") FROM "Invoice" GROUP BY "BillingCountry";

-- Provide a query that shows the total number of tracks in each playlist. 
-- The Playlist name should be included on the resultant table

SELECT COUNT("PlaylistId") FROM "PlaylistTrack" GROUP BY "PlaylistId"; -- ?

-- Provide a query that shows all the Tracks, but displays no IDs. 
-- The resultant table should include the Album name, Media type and Genre

SELECT  "Album"."Title", "MediaType"."Name", "Genre"."Name"  FROM "Album", "MediaType", "Genre"; -- ?