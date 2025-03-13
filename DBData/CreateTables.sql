create database sitematerialinventorydb;

use sitematerialinventorydb;
-- USERS AND ROLES
CREATE TABLE Roles (
    roleid INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(50) NOT NULL
);

CREATE TABLE Users (
    userid INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password_hash VARCHAR(255),
    roleid INT,
    FOREIGN KEY (roleid) REFERENCES Roles(roleid)
);

-- MATERIAL MASTER
CREATE TABLE Materials (
    materialid INT PRIMARY KEY AUTO_INCREMENT,
    material_name VARCHAR(100) NOT NULL,
    unit VARCHAR(20),
    reorder_level INT
);

-- SUPPLIERS
CREATE TABLE Suppliers (
    supplierid INT PRIMARY KEY AUTO_INCREMENT,
    supplier_name VARCHAR(100),
    contact_person VARCHAR(100),
    phone_number VARCHAR(15)
);

-- CONSTRUCTION SITES (PROJECTS)
CREATE TABLE Sites (
    siteid INT PRIMARY KEY AUTO_INCREMENT,
    site_name VARCHAR(100),
    location VARCHAR(100),
    start_date DATE,
    end_date DATE
);

-- STOCK PER SITE
CREATE TABLE material_site_stock (
    id INT PRIMARY KEY AUTO_INCREMENT,
    siteid INT,
    materialid INT,
    current_stock INT DEFAULT 0,
    FOREIGN KEY (siteid) REFERENCES Sites(siteid),
    FOREIGN KEY (materialid) REFERENCES Materials(materialid)
);

-- STOCK TRANSACTIONS (IN/OUT)
CREATE TABLE stock_transactions (
    transactionid INT PRIMARY KEY AUTO_INCREMENT,
    siteid INT,
    supplierid INT,
    date DATE,
    type ENUM('IN', 'OUT'),
    quantity INT,
    supplierid INT,
    remarks TEXT,
    FOREIGN KEY (siteid) REFERENCES Sites(siteid),
    FOREIGN KEY (materialid) REFERENCES Materials(materialid),
    FOREIGN KEY (supplierid) REFERENCES Suppliers(supplierid)
);

-- MATERIAL REQUESTS
CREATE TABLE material_requests (
    requestid INT PRIMARY KEY AUTO_INCREMENT,
    site_id INT,
    material_id INT,
    requested_by INT,
    quantity INT,
    date DATE,
    status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending',
    FOREIGN KEY (site_id) REFERENCES Sites(site_id),
    FOREIGN KEY (material_id) REFERENCES Materials(material_id),
    FOREIGN KEY (requested_by) REFERENCES Users(requested_by)
);


-- APPROVAL TRACKING
CREATE TABLE Approvals (
    approvalid INT PRIMARY KEY AUTO_INCREMENT,
    requestid INT,
    approved_by INT,
    approved_date DATE,
    comments TEXT,
    FOREIGN KEY (requestid) REFERENCES material_requests(requestid),
    FOREIGN KEY (approved_by) REFERENCES Users(userid)
);

-- DAILY CONSUMPTION REPORTS
CREATE TABLE daily_consumption_reports (
    reportid INT PRIMARY KEY AUTO_INCREMENT,
    siteid INT,
    date DATE,
    materialid INT,
    quantity_used INT,
    used_by VARCHAR(100),
    work_detail TEXT,
    FOREIGN KEY (siteid) REFERENCES Sites(siteid),
    FOREIGN KEY (materialid) REFERENCES Materials(materialid)
);

-- LOW STOCK ALERTS
CREATE TABLE low_stock_alerts (
    alertid INT PRIMARY KEY AUTO_INCREMENT,
    siteid INT,
    materialid INT,
    date DATE,
    current_stock INT,
    reorder_level INT,
    action_taken VARCHAR(100),
    FOREIGN KEY (siteid) REFERENCES Sites(siteid),
    FOREIGN KEY (materialid) REFERENCES Materials(materialid)
);
