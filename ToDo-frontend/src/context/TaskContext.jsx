import { createContext, useState, useEffect } from "react";
import { getTasks, addTask, completeTask } from "../services/api";

export const TaskContext = createContext();

export const TaskProvider = ({ children }) => {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    const data = await getTasks();
    setTasks(data.slice(-5)); // Show only the last 5 tasks
  };

  const handleAddTask = async (task) => {
    await addTask(task);
    fetchTasks();
  };

  const handleCompleteTask = async (taskId) => {
    await completeTask(taskId);
    fetchTasks();
  };

  return (
    <TaskContext.Provider value={{ tasks, handleAddTask, handleCompleteTask }}>
      {children}
    </TaskContext.Provider>
  );
};