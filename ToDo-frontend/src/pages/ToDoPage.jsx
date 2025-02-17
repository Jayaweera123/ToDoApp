import { useState } from "react";
import ToDoForm from "../components/ToDoForm";
import ToDoCard from "../components/ToDoCard";
import backgroundImage from "../assets/background.jpg"; // Import the image

const ToDoPage = () => {
  const [tasks, setTasks] = useState([]);

  const addTask = (task) => {
    setTasks([...tasks, task]);
  };

  const removeTask = (index) => {
    setTasks(tasks.filter((_, i) => i !== index));
  };

  return (
    <div
      className="flex justify-center items-center h-screen w-screen bg-cover bg-center relative"
      style={{ backgroundImage: `url(${backgroundImage})` }}
    >
      {/* Mist Overlay */}
      <div className="absolute inset-0absolute inset-0 bg-black/50"></div>

      <div className="flex w-full max-w-6xl relative z-10 p-5 bg-white/20 backdrop-blur-lg shadow-lg rounded-lg">
        {/* Left Side - Form (Fixed Width) */}
        <div className="w-[40%] p-5">
          <ToDoForm addTask={addTask} />
        </div>

        {/* Vertical Divider */}
        <div className="w-[2px] bg-gray-400 mx-4"></div>

        {/* Right Side - Task Cards (Fixed Width) */}
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
