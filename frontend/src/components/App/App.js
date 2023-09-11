import './App.css';
import React, {Component} from "react";
import EShopService from "../../repository/eshopRepository";
import {BrowserRouter as Router, Navigate, Route, Routes} from 'react-router-dom'
import Books from '../Books/BookList/books';
import Header from '../Header/header';
import Authors from "../Authors/authors";
import Categories from '../Categories/categories';
import BookAdd from '../Books/BookAdd/bookAdd';
import BookEdit from "../Books/BookEdit/bookEdit";
import Countries from "../Countries/countries";

class App extends Component {

  constructor(props) {
    super(props);
      this.state = {
          books: [],
          authors: [],
          categories: [],
          countries: [],
          selectedBook: {}
      }
  }

  render() {
    return (

        <Router>
            <main>
                <Header/>
                <div className="container">
                  <Routes>
                      <Route path={"/categories"}
                             element={<Categories categories={this.state.categories}/>} exact/>
                      <Route path={"/books/add"}
                             element={<BookAdd categories={this.state.categories}
                                               authors={this.state.authors}
                                               onAddBook={this.addBook}/>} exact/>
                      <Route path={"/books/edit/:id"}
                             element={<BookEdit categories={this.state.categories}
                                                authors={this.state.authors}
                                                onEditBook={this.editBook}
                                                book={this.state.selectedBook}
                             />} exact/>
                      <Route path={"/books"}
                             element={<Books books={this.state.books}
                                             onDelete={this.deleteBook}
                                             onEdit={this.fetchBookById}
                                             onMarkAsTaken={this.markBookAsTaken}
                             />}
                             exact/>

                      <Route path={"/countries"}
                             element={<Countries countries={this.state.countries}/>} exact/>
                      <Route path="/" element={<Navigate replace to="/books"/>}/>
                    </Routes>
                </div>
          </main>
        </Router>

    );
  }

    loadBooks = () => {
        EShopService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            })
    }

    fetchBookById = (id) => {
        EShopService.fetchBookById(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }

    addBook = (name, category, author, availableCopies) => {
        EShopService.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            })
    }

    editBook = (id, name, category, author, availableCopies) => {
        EShopService.editBook(id, name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    deleteBook = (id) => {
        EShopService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }

    markBookAsTaken = (id) => {
        EShopService.markBookAsTaken(id)
            .then(() => {
                this.loadBooks();
            });
    }

    loadCategories = () => {
        EShopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            })
    }

    loadAuthors = () => {
        EShopService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            })
    }

    loadCountries = () => {
        EShopService.fetchCountries()
            .then((data) => {
                this.setState({
                    countries: data.data
                })
            })
    }

    componentDidMount() {
        this.loadAuthors();
        this.loadCategories();
        this.loadBooks();
        this.loadCountries();
    }
}

export default App;
