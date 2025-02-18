import { useState, useEffect } from "react";
import ToDoForm from "../components/ToDoForm";
import ToDoCard from "../components/ToDoCard";
import backgroundImage from "../assets/background.jpg";

const ToDoPage = () => {
  const [tasks, setTasks] = useState([]);
  const [showSuccess, setShowSuccess] = useState(false);

  const addTask = (task) => {
    setTasks([...tasks, task]);
    setShowSuccess(true); // Show popup

    // Hide popup after 2 seconds
    setTimeout(() => {
      setShowSuccess(false);
    }, 2000);
  };

  // Hide popup on Enter key press
  useEffect(() => {
    const handleKeyDown = (e) => {
      if (e.key === "Enter") {
        setShowSuccess(false);
      }
    };

    document.addEventListener("keydown", handleKeyDown);
    return () => document.removeEventListener("keydown", handleKeyDown);
  }, []);

  return (
    <div
      className="flex justify-center items-center h-screen w-screen bg-cover bg-center relative"
      style={{ backgroundImage: `url(${backgroundImage})` }}
    >
      {/* Mist Overlay */}
      <div className="absolute inset-0 bg-black/50"></div>

      {/* ✅ Fixed Popup Message */}
      {showSuccess && (
  <div className="fixed top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 
    bg-gray-800/90 text-white px-10 py-6 rounded-xl shadow-2xl text-center text-xl font-bold 
    z-50 w-96 sm:w-80 animate-fade-in">
    ✅ Task Added Successfully!
  </div>
)}


      <div className="flex w-full max-w-6xl relative z-10 p-5 bg-white/20 backdrop-blur-lg shadow-lg rounded-lg">
        {/* Left Side - Form */}
        <div className="w-[40%] p-5">
          <ToDoForm addTask={addTask} />
        </div>

        {/* Vertical Divider */}
        <div className="w-[2px] bg-gray-400 mx-4"></div>

        {/* Right Side - Task Cards */}
        <div className="w-[60%] space-y-6 overflow-y-auto max-h-[500px] p-5">
          {tasks.map((task, index) => (
            <ToDoCard key={index} task={task} onDelete={() => removeTask(index)} />
          ))}
        </div>
      </div>
    </div>
  );
};

export default ToDoPage;
