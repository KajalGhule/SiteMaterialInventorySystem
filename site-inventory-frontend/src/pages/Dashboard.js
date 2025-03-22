import React, { useEffect, useState } from 'react';
import API from '../services/api';

function Dashboard() {
  const [lowStock, setLowStock] = useState([]);
  const [error, setError] = useState("");

  useEffect(() => {
    API.get('/reports/low-stock')
      .then(res => setLowStock(res.data))
      .catch(err => setError("Failed to fetch data"));
  }, []);

  return (
    <div style={{ padding: '20px' }}>
      <h2>📉 Low Stock Materials</h2>
      {error && <p>{error}</p>}
      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Material</th>
            <th>Current Stock</th>
            <th>Site</th>
          </tr>
        </thead>
        <tbody>
          {lowStock.map(item => (
            <tr key={item.id}>
              <td>{item.material.materialName}</td>
              <td>{item.currentStock}</td>
              <td>{item.site.siteName}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Dashboard;
