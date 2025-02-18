import { useState, useEffect } from "react";
import ToDoForm from "../components/ToDoForm";
import ToDoCard from "../components/ToDoCard";
import backgroundImage from "../assets/background.jpg";
import { getTasks, completeTask } from "../services/api";
import Swal from 'sweetalert2'

const ToDoPage = () => {
  const [tasks, setTasks] = useState([]);
  const [showSuccess, setShowSuccess] = useState(false);

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    try {
      const data = await getTasks();
      setTasks(data); // Ensure we always get the latest tasks
    } catch (error) {
      console.error("Error fetching tasks:", error);
    }
  };

  const handleCompleteTask = async (taskId) => {
    Swal.fire({
      title: "Are you sure?",
      text: "This task will be marked as completed!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#001b5e",
      cancelButtonColor: "#6b7280",
      confirmButtonText: "Yes, delete it!",
      iconColor: "#000000"
    }).then(async (result) => {
      if (result.isConfirmed) {
        try {
          await completeTask(taskId);
          fetchTasks();
          Swal.fire({
            title: "Deleted!",
            text: "The task has been marked as completed.",
            icon: "success",
            confirmButtonColor: "#001b5e",
            iconColor: "#000000"
          });
        } catch (error) {
          console.error("Error completing task:", error);
        }
      }
    });
  };

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
          <ToDoForm onTaskAdded={fetchTasks} />
        </div>

        {/* Vertical Divider */}
        <div className="w-[2px] bg-gray-400 mx-4"></div>

        {/* Right Side - Task Cards */}
        <div className="w-[60%] space-y-6 overflow-y-auto max-h-[500px] p-5">
        {tasks.map((task) => (
            <ToDoCard 
              key={task.id} 
              task={task} 
              onComplete={() => handleCompleteTask(task.id)} 
            />
          ))}
        </div>
      </div>
    </div>
  );
};

export default ToDoPage;
