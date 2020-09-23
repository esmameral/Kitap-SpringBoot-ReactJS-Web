import React from 'react';

class Thumbnail extends React.Component {
    render() {
        return <img src={this.props.src} alt={this.props.src} width="100" height="100" />
    }
}

export default Thumbnail;
