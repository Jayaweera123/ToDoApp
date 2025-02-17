import { useState } from "react";
import ToDoForm from "../components/ToDoForm";
import ToDoCard from "../components/ToDoCard";

const ToDoPage = () => {
  const [tasks, setTasks] = useState([]);

  const addTask = (task) => {
    setTasks([...tasks, task]);
  };

  const removeTask = (index) => {
    setTasks(tasks.filter((_, i) => i !== index));
  };

  return (
    <div className="flex justify-center items-center min-h-screen bg-gray-100">
      <div className="flex w-3/4 gap-12">
        {/* Left Side - Form */}
        <div className="w-2/5">
          <ToDoForm addTask={addTask} />
        </div>

        {/* Right Side - Task Cards */}
        <div className="w-3/5 space-y-4">
          {tasks.map((task, index) => (
            <ToDoCard key={index} task={task} onDelete={() => removeTask(index)} />
          ))}
        </div>
      </div>
    </div>
  );
};

export default ToDoPage;
