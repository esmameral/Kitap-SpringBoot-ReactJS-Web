import React, { Component } from 'react';
import './App.css';

class App extends Component {
    render() {
        return (
            <div className="App">
                <h1 className="text-center">Ürün Listesi</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Resim</th>
                            <th>İsim</th>
                            <th>Fiyat</th>
                            <th>Ürün Tanımı</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><img src={require('./images/tablet.jpg')} alt="img-tablet" width="100" height="100"/></td>
                            <td>32GB Tablet Gümüş</td>
                            <td>702 TL</td>
                            <td>Depolama birimi:RAM 2GB, Dahili Hafıza: 32 GB, Ekran boyutu: 8 '',Dokunmatik ekran,  Hafıza: 2GB ,Batarya Pil performansı: 5100 mAh, Ekran boyutu: 8 '',Ekran boyutu: 8 '', Ekran çözünürlüğü 1280 x 800 Piksel, Platform: Android</td>
                        </tr>
                        <tr>
                            <td><img src={require('./images/shoe.jpg')} alt="img-shoe" width="100" height="100"/></td>
                            <td>Erkek Ayakkabı</td>
                            <td>150 TL</td>
                            <td>Soğuk ve suya karşı dayanıklı, Kaymaz taban, Bağcıklı, Anatomik Kalıp, Dış Materyal : Su Geçirmez 1.Sınıf İthal Microfiber Malzeme İç Materyal : Soğuk Geçirmez 1.Kalite İthal Kürk</td>
                        </tr>
                        <tr>
                            <td><img src={require('./images/watch.jpg')} alt="img-watch" width="100" height="100"/></td>
                            <td>Kadın Saat</td>
                            <td>200 TL</td>
                            <td>Cinsiyet: Kadın, Çalışma Tipi: Pilli (Quartz), Kordon Rengi: Gri, Kordon: Çelik, Su Geçirmezlik: 30 m</td>
                        </tr>
            <tr>
                            <td><img src={require('./images/chair.jpg')} alt="img-chair" width="100" height="100"/></td>
                            <td>Masa Sandalyesi</td>
                            <td>400 TL</td>
                            <td>Yumuşak dokulu döşeme. Kolay silinebilir yüzey. Sandalye Yükseklik 92cm / Genişlik 40cm· Ürün demonte olarak gönderilmektedir, kurulum alıcıya ait ve basittir. </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        );
    }
}

export default App;

