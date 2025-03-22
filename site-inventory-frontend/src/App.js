import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Dashboard from './pages/Dashboard';
import DailyUsageForm from './components/DailyUsageForm';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/daily-usage" element={<DailyUsageForm />} />
      </Routes>
    </Router>
  );
}

export default App;
