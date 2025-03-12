create database sitematerialinventorydb;

use sitematerialinventorydb;
-- USERS AND ROLES
CREATE TABLE Roles (
    RoleID INT PRIMARY KEY AUTO_INCREMENT,
    RoleName VARCHAR(50) NOT NULL
);

CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Email VARCHAR(100) UNIQUE,
    PasswordHash VARCHAR(255),
    RoleID INT,
    FOREIGN KEY (RoleID) REFERENCES Roles(RoleID)
);

-- MATERIAL MASTER
CREATE TABLE Materials (
    MaterialID INT PRIMARY KEY AUTO_INCREMENT,
    MaterialName VARCHAR(100) NOT NULL,
    Unit VARCHAR(20),
    ReorderLevel INT
);

-- SUPPLIERS
CREATE TABLE Suppliers (
    SupplierID INT PRIMARY KEY AUTO_INCREMENT,
    SupplierName VARCHAR(100),
    ContactPerson VARCHAR(100),
    PhoneNumber VARCHAR(15)
);

-- CONSTRUCTION SITES (PROJECTS)
CREATE TABLE Sites (
    SiteID INT PRIMARY KEY AUTO_INCREMENT,
    SiteName VARCHAR(100),
    Location VARCHAR(100),
    StartDate DATE,
    EndDate DATE
);

-- STOCK PER SITE
CREATE TABLE MaterialSiteStock (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    SiteID INT,
    MaterialID INT,
    CurrentStock INT DEFAULT 0,
    FOREIGN KEY (SiteID) REFERENCES Sites(SiteID),
    FOREIGN KEY (MaterialID) REFERENCES Materials(MaterialID)
);

-- STOCK TRANSACTIONS (IN/OUT)
CREATE TABLE StockTransactions (
    TransactionID INT PRIMARY KEY AUTO_INCREMENT,
    SiteID INT,
    MaterialID INT,
    Date DATE,
    Type ENUM('IN', 'OUT'),
    Quantity INT,
    SupplierID INT,
    Remarks TEXT,
    FOREIGN KEY (SiteID) REFERENCES Sites(SiteID),
    FOREIGN KEY (MaterialID) REFERENCES Materials(MaterialID),
    FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID)
);

-- MATERIAL REQUESTS
CREATE TABLE MaterialRequests (
    RequestID INT PRIMARY KEY AUTO_INCREMENT,
    SiteID INT,
    MaterialID INT,
    RequestedBy INT,
    Quantity INT,
    Date DATE,
    Status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending',
    FOREIGN KEY (SiteID) REFERENCES Sites(SiteID),
    FOREIGN KEY (MaterialID) REFERENCES Materials(MaterialID),
    FOREIGN KEY (RequestedBy) REFERENCES Users(UserID)
);

-- APPROVAL TRACKING
CREATE TABLE Approvals (
    ApprovalID INT PRIMARY KEY AUTO_INCREMENT,
    RequestID INT,
    ApprovedBy INT,
    ApprovedDate DATE,
    Comments TEXT,
    FOREIGN KEY (RequestID) REFERENCES MaterialRequests(RequestID),
    FOREIGN KEY (ApprovedBy) REFERENCES Users(UserID)
);

-- DAILY CONSUMPTION REPORTS
CREATE TABLE DailyConsumptionReports (
    ReportID INT PRIMARY KEY AUTO_INCREMENT,
    SiteID INT,
    Date DATE,
    MaterialID INT,
    QuantityUsed INT,
    UsedBy VARCHAR(100),
    WorkDetail TEXT,
    FOREIGN KEY (SiteID) REFERENCES Sites(SiteID),
    FOREIGN KEY (MaterialID) REFERENCES Materials(MaterialID)
);

-- LOW STOCK ALERTS
CREATE TABLE LowStockAlerts (
    AlertID INT PRIMARY KEY AUTO_INCREMENT,
    SiteID INT,
    MaterialID INT,
    Date DATE,
    CurrentStock INT,
    ReorderLevel INT,
    ActionTaken VARCHAR(100),
    FOREIGN KEY (SiteID) REFERENCES Sites(SiteID),
    FOREIGN KEY (MaterialID) REFERENCES Materials(MaterialID)
);
