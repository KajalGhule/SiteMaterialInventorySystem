use sitematerialinventorydb;

-- Insert Roles
INSERT INTO Roles (RoleName) VALUES 
('Admin'), 
('SiteManager'), 
('Supervisor'), 
('Storekeeper');

-- Insert Users
INSERT INTO Users (Name, Email, PasswordHash, RoleID) VALUES
('Kajal Ghule', 'admin@site.com', 'password123', 1),
('Omkar Ghule', 'omkar@site.com', 'password123', 2),
('Sneha Patil', 'sneha@site.com', 'password123', 3),
('Ashish Patil', 'ashish@site.com', 'password123', 4);

-- Insert Sites
INSERT INTO Sites (SiteName, Location, StartDate, EndDate) VALUES
('Tower A Construction', 'Pune', '2025-04-01', '2025-12-31'),
('Warehouse B Project', 'Mumbai', '2025-05-10', '2026-01-15');

-- Insert Materials
INSERT INTO Materials (MaterialName, Unit, ReorderLevel) VALUES
('Cement', 'Bags', 100),
('Sand', 'Tons', 20),
('Steel Rods', 'Kg', 500),
('Bricks', 'Pieces', 1000),
('Paint', 'Liters', 50);

-- Insert Suppliers
INSERT INTO Suppliers (SupplierName, ContactPerson, PhoneNumber) VALUES
('BuildMart Ltd.', 'Rajesh Mehta', '9876543210'),
('UltraMaterials Co.', 'Sneha Patil', '9123456780'),
('Reliable Suppliers', 'Amit Sharma', '9988776655');

-- Insert Material Site Stock
INSERT INTO MaterialSiteStock (SiteID, MaterialID, CurrentStock) VALUES
(1, 1, 130),
(1, 2, 18),
(1, 3, 420),
(2, 1, 200);

-- Insert Stock Transactions
INSERT INTO StockTransactions (SiteID, MaterialID, Date, Type, Quantity, SupplierID, Remarks) VALUES
(1, 1, '2025-06-01', 'IN', 200, 1, 'Initial delivery'),
(1, 1, '2025-06-03', 'OUT', 50, NULL, 'Used for foundation'),
(1, 2, '2025-06-02', 'IN', 40, 2, 'Top-up stock'),
(1, 3, '2025-06-04', 'OUT', 100, NULL, 'Used for columns');

-- Insert Material Requests
INSERT INTO MaterialRequests (SiteID, MaterialID, RequestedBy, Quantity, Date, Status) VALUES
(1, 4, 2, 2000, '2025-06-02', 'Approved'),
(1, 1, 3, 100, '2025-06-03', 'Pending');

-- Insert Approvals
INSERT INTO Approvals (RequestID, ApprovedBy, ApprovedDate, Comments) VALUES
(1, 1, '2025-06-02', 'Approved for Site A');

-- Insert Daily Consumption Reports
INSERT INTO DailyConsumptionReports (SiteID, Date, MaterialID, QuantityUsed, UsedBy, WorkDetail) VALUES
(1, '2025-06-03', 1, 25, 'Ramesh', 'Slab casting'),
(1, '2025-06-03', 3, 80, 'Ganesh', 'Column steel work'),
(1, '2025-06-04', 2, 10, 'Suresh', 'Plastering base mix');

-- Insert Low Stock Alerts
INSERT INTO LowStockAlerts (SiteID, MaterialID, Date, CurrentStock, ReorderLevel, ActionTaken) VALUES
(1, 3, '2025-06-05', 420, 500, 'Reordered'),
(1, 5, '2025-06-04', 40, 50, 'Alert Sent');
