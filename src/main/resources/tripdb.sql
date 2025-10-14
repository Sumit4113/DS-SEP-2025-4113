CREATE DATABASE IF NOT EXISTS tripdb;
USE tripdb;

CREATE TABLE IF NOT EXISTS trips (
  id INT AUTO_INCREMENT PRIMARY KEY,
  destination VARCHAR(255) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  price DOUBLE NOT NULL,
  status VARCHAR(50) NOT NULL
);

-- sample data
INSERT INTO trips (destination, start_date, end_date, price, status)
VALUES
('Paris', '2025-09-10', '2025-09-20', 1500.00, 'PLANNED'),
('London', '2025-08-01', '2025-08-10', 1200.00, 'COMPLETED'),
('Tokyo', '2025-12-05', '2025-12-15', 3000.00, 'PLANNED');
