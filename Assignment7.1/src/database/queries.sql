-- Retrieve all currencies
SELECT * FROM Currency;

-- Retrieve EUR
SELECT * FROM Currency WHERE abbreviation = 'EUR';

-- Count number of currencies
SELECT COUNT(*) AS total_currencies FROM Currency;

-- Retrieve currency with highest exchange rate
SELECT * FROM Currency ORDER BY exchange_rate DESC LIMIT 1;
