import { useContext } from "react";
import { TaskContext } from "../context/TaskContext";

const TaskItem = ({ task }) => {
  const { handleCompleteTask } = useContext(TaskContext);

  return (
    <div className="flex justify-between items-center bg-gray-200 p-4 rounded mb-2">
      <div>
        <h3 className="font-bold">{task.title}</h3>
        <p>{task.description}</p>
      </div>
      <button
        className="border px-4 py-2 rounded"
        onClick={() => handleCompleteTask(task.id)}
      >
        Done
      </button>
    </div>
  );
};

export default TaskItem;