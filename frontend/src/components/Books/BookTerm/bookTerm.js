import React from 'react';
import {Link} from 'react-router-dom';

const bookTerm = (props) => {
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.author.name} {props.term.author.surname}</td>
            <td>{props.term.availableCopies}</td>
            <td className={"text-right"}>
                <a title={"Delete"}
                   className={"mx-2 btn btn-outline-dark"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
                <Link className={"mx-2 btn btn-light"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/edit/${props.term.id}`}>
                    Edit
                </Link>
                <a title={"Mark As Taken"} className={"mx-2 btn btn-outline-primary"}
                   onClick={() => props.onMarkAsTaken(props.term.id)}>
                    Mark As Taken
                </a>
            </td>
        </tr>
    )
}

export default bookTerm;