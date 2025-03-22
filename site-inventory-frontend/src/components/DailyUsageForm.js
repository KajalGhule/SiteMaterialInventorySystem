import React, { useEffect, useState } from 'react';
import API from '../services/api';

function DailyUsageForm() {
  const [sites, setSites] = useState([]);
  const [materials, setMaterials] = useState([]);
  const [loading, setLoading] = useState(false);

  const [formData, setFormData] = useState({
    siteID: '',
    materialID: '',
    date: '',
    quantityUsed: '',
    usedBy: '',
    workDetail: ''
  });

  useEffect(() => {
    API.get('/sites/all').then(res => setSites(res.data));
    API.get('/materials').then(res => setMaterials(res.data));
  }, []);

  const handleChange = e => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async e => {
    e.preventDefault();

    // Basic validation: quantityUsed should be positive number
    if (parseInt(formData.quantityUsed) <= 0) {
      alert("Quantity used must be greater than zero.");
      return;
    }

    const payload = {
      site: { siteID: parseInt(formData.siteID) },
      material: { materialID: parseInt(formData.materialID) },
      date: formData.date,
      quantityUsed: parseInt(formData.quantityUsed),
      usedBy: formData.usedBy.trim(),
      workDetail: formData.workDetail.trim()
    };

    try {
      setLoading(true);
      await API.post('/reports/daily/usage', payload);
      alert("Usage reported successfully!");
      setFormData({ siteID: '', materialID: '', date: '', quantityUsed: '', usedBy: '', workDetail: '' });
    } catch (err) {
      alert("Error submitting usage report.");
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={{ padding: '20px', maxWidth: '400px', margin: 'auto' }}>
      <h2>📋 Report Daily Material Usage</h2>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '12px' }}>
          <label>Site:</label><br />
          <select name="siteID" value={formData.siteID} onChange={handleChange} required>
            <option value="">Select Site</option>
            {sites.map(site => (
              <option key={site.siteID} value={site.siteID}>{site.siteName}</option>
            ))}
          </select>
        </div>
        <div style={{ marginBottom: '12px' }}>
          <label>Material:</label><br />
          <select name="materialID" value={formData.materialID} onChange={handleChange} required>
            <option value="">Select Material</option>
            {materials.map(mat => (
              <option key={mat.materialID} value={mat.materialID}>{mat.materialName}</option>
            ))}
          </select>
        </div>
        <div style={{ marginBottom: '12px' }}>
          <label>Date:</label><br />
          <input type="date" name="date" value={formData.date} onChange={handleChange} required />
        </div>
        <div style={{ marginBottom: '12px' }}>
          <label>Quantity Used:</label><br />
          <input
            type="number"
            name="quantityUsed"
            value={formData.quantityUsed}
            onChange={handleChange}
            required
            min="1"
            step="1"
          />
        </div>
        <div style={{ marginBottom: '12px' }}>
          <label>Used By:</label><br />
          <input type="text" name="usedBy" value={formData.usedBy} onChange={handleChange} required />
        </div>
        <div style={{ marginBottom: '12px' }}>
          <label>Work Detail:</label><br />
          <input type="text" name="workDetail" value={formData.workDetail} onChange={handleChange} required />
        </div>
        <button type="submit" disabled={loading}>
          {loading ? "Submitting..." : "Submit Report"}
        </button>
      </form>
    </div>
  );
}

export default DailyUsageForm;
