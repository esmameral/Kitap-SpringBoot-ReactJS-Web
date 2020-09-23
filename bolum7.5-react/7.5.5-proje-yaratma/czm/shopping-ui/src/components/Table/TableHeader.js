import React from 'react';

class TableHeader extends React.Component {
    render() {
        return (
            <thead>
                <tr>
                    <th>Resim</th>
                    <th>İsim</th>
                    <th>Fiyat</th>
                    <th>Ürün Tanımı</th>
                </tr>
            </thead>);
    }
}

export default TableHeader;
