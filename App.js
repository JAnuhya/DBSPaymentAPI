//import logo from './logo.svg';
//import './App.css';
//import {SenderDetails} from "./SenderDetails"
import {Routes,Route} from "react-router-dom"
import {SenderForm} from "./SenderForm"
//import ReceiverDetails from "./ReceiverDetails"
import TransactionDetails from "./TransactionDetails"
import Transaction from "./Transaction"
import TransactionResponse from "./TransactionResponse"
import ShowTransaction from "./ShowTransaction"
import ErrorMessage from "./ErrorMessage"

function App() {
  return (
    <div className="App">
       
       {/* <Routes> 
         <Route path="/" element={<SenderForm/>}></Route>
         <Route path="/sreceiver" element={<ReceiverDetails/>}></Route>
         <Route path="/transaction" element={<TransactionDetails/>}></Route>

       </Routes> */}
        {/* <Transaction/>
        <Routes>
          <Route path="/final" element={<ShowTransaction/>}/>
        </Routes> */}
        <Routes>
        <Route path="/" element={<Transaction/>}/>
       <Route path="/transactionResponse/:id" element={<ShowTransaction/>}/>
       <Route path="/errorMessage/:eid" element={<ErrorMessage/>}/>
       </Routes>
    </div>
    
  );
}

export default App;
