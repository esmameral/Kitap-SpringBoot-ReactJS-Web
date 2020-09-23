import React from 'react';
import Thumbnail from '../Thumbnail';
import images from '../../images/index';



export default class TableBody extends React.Component {
    render() {
        const { list } = this.props;
        return (
            <tbody>
                {list.map((item) => {
                    return (<tr key={item.id}>
                        <td><Thumbnail src={images[item.img]} /></td>
                        <td>{item.name}</td>
                        <td>{item.price}</td>
                        <td>{item.description}</td>
                    </tr>);
                })}
            </tbody>);
    }
}


