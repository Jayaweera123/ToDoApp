import TaskForm from "./components/TaskForm";
import TaskList from "./components/TaskList";
import { TaskProvider } from "./context/TaskContext";

const App = () => {
  return (
    <TaskProvider>
      <div className="min-h-screen bg-gray-100 flex flex-col items-center justify-center">
        <div className="w-full max-w-md">
          <TaskForm />
          <TaskList />
        </div>
      </div>
    </TaskProvider>
  );
};

export default App;

